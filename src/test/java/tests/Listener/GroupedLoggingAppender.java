package tests.Listener;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class GroupedLoggingAppender extends AppenderSkeleton implements IReporter {

    private final ConcurrentHashMap<Long, BufferedWriter> tid2file = new ConcurrentHashMap<Long, BufferedWriter>();
    private final String outputDir;
    private final String outputFile;
    private final String ext = ".log";

    public GroupedLoggingAppender() {
        String workingDir = System.getProperty("user.dir");
        String outdir = workingDir + "\\logs\\";
        if (!outdir.endsWith("/"))
            outdir += "/";
        outputDir = outdir;

        outputFile = outputDir + "Allgrouped.log";
        try {
            if (outputDir != null) {
                Files.deleteIfExists(FileSystems.getDefault().getPath(outputFile));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        System.out.println("Reporter getting called! " + outputDir);
        // we don't do any report generation here, just clean up the log files
        mergeLogFiles();
    }

    @Override
    public void close() {
    }

    private void mergeLogFiles() {
        try {
            File file = new File(outputDir);
            File[] files = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(ext);
                }
            });

            List<Path> paths = new ArrayList<Path>();
            for (File f : files) {
                Path path = f.toPath();
                paths.add(path);
            }
            Collections.sort(paths);
            Path pathAll = FileSystems.getDefault().getPath(outputFile);
            for (Path path : paths) {
                Files.write(pathAll, Files.readAllBytes(path), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                Files.delete(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void append(LoggingEvent event) {
        if (outputDir == null)
            return; // by default nothing appended, see comments on top
        try {
            long tid = Thread.currentThread().getId();
            String tName = Thread.currentThread().getName();
            String[] tClassName = tName.split("=");
            BufferedWriter fw = tid2file.get(tid);
            if (fw == null) {
                fw = new BufferedWriter(new FileWriter(getFileNameFromThreadID(tid, tClassName[1])));
                tid2file.put(tid, fw);
            }

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String suffix = dateFormat.format(new Date());
            suffix += " [" + event.getLevel() + "]";

            fw.write(suffix + " : " + event.getMessage().toString());
            fw.write("\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private String getFileNameFromThreadID(long tid, String tClassName) {
        return String.format("%s" + tClassName + "%s", outputDir, tid, ext);
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
