package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;

public class ExcelReader {
    public Workbook workbook;



    /**
     * Return the rows from the Excel sheet as string cell values.
     *
     * @param sheetName String
     * @return ArrayList
     */
    public ArrayList<ArrayList<String>> getRows(String sheetName) {
        Sheet sheet = this.workbook.getSheet(sheetName);
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        sheet.removeRow(sheet.getRow(0));
        for (Row row : sheet) {
            ArrayList<String> dataRow = new ArrayList<>();
            for (Cell cell : row) {
                FormulaEvaluator evaluator = this.workbook.getCreationHelper().createFormulaEvaluator();
                DataFormatter formatter = new DataFormatter();
                String value = formatter.formatCellValue(cell, evaluator);
                dataRow.add(value);
            }
            data.add(dataRow);
        }
        return data;
    }


    public String[][] getExcelData(String fileName, String sheetName){

        String[][] data = null;
        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh = wb.getSheet(sheetName);
            XSSFRow row = sh.getRow(0);
            DataFormatter formatter = new DataFormatter();
            int noOfRows = sh.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows-1][noOfCols];
            for(int i =1; i<noOfRows;i++){
                for(int j=0;j<noOfCols;j++){
                    row = sh.getRow(i);
                    cell= row.getCell(j);
                    data[i-1][j] = formatter.formatCellValue(cell);
                }
            }

        }
        catch (Exception e) {
            System.out.println("The exception is: " +e.getMessage());
        }
        return data;
    }
}
