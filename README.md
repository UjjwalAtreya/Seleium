## Folder Structure

```
selenium_javaFramework
|   excels
|   logoAndSvgs
|   logs
|   reports 
└─── src
|	 └─── main
|	 |    └─── java
|	 |    |    └─── PageObjects
|	 |    |	        └─── FrontOffice
|	 |    |	        |       | LoginPage.java
|	 |    |         └─── BackOffice  
|	 |    |	        └─── Utils
|	 |    |	        |       | ExcelReader.java
|	 |    |	        |       | ExtentManager.java
|	 |    |         |       | ExtentTestManager.java
|	 |    |         |       | Helper
|	 └─── test
|	 |    └─── java
|	 |    |    └─── tests
|	 |    |    |    └─── Listener
|	 |    |    |            | AnnotationTransformer.java
|	 |    |    |            | GroupedLoggingAppender.java
|	 |    |    |            | ListenerClass.java
|	 |    |    |            | Retry.java
|	 |    |    |            | TestListener.java
|	 |    |    |            | WebDriverListener.java 
|	 |    |    |    └─── loginTest
|	 |    |    |            | BaseLogin.java
|	 |    |    |            | DataProviderClass.java
|	 |    |    |            | Setup.java
| 	suiteXml
|   videos
|   .gitignore
|   pom.xml 
```

# Introduction:

A Data-Driven Selenium Java's automation framework for web automation Testing.

# Project Execution Guidelines:

1. Clone Git Repository 'git clone {repoURL}'
2. Run command 'mvn clean test -DsuiteXmlFile="suitexml/config/testNg.xml"'

# Installation and Setup Guidelines:

1. To Install the JDK Software and Set JAVA_HOME on a Windows System
2. Install the JDK software.
   -> Go to http://java.sun.com/javase/downloads/index.jsp.
   -> Select the appropriate JDK software and click Download.
   The JDK software is installed on your computer, for example,
   at C:\Program Files\Java\jdk1.6.0_02. You can move the JDK software to another location if desired.
3. Set JAVA_HOME:
   -> Right-click My Computer and select Properties.
   -> On the Advanced tab, select Environment Variables, and then edit JAVA_HOME
   to point to where the JDK software is located, for example, C:\Program Files\Java\jdk1.6.0_02.
4. Set MAVEN_HOME
   -> Right-click My Computer and select Properties.
   -> On the Advanced tab, select Environment Variables, and then edit MAVEN_HOME to point to where
      the Maven software is located, for example, C:\Program Files\apache-maven-3.9.1
5. IDE Install (Intellij and Eclipse)
   Eclipse IDE https://www.eclipse.org/downloads/
   Intellij IDE https://www.jetbrains.com/idea/download/#section=windows

# src/main/java/Utils/ExcelReader :

# src/main/java/Utils/ExtentManager :

# src/main/java/Utils/ExtentTestManager :

# src/main/java/Utils/Helper :

# src/test/java/tests/listener/AnnotationTransformer :

# src/test/java/tests/listener/GroupedLoggingAppender :

# src/test/java/tests/listener/ListenerClass :

# src/test/java/tests/listener/Retry :

# src/test/java/tests/listener/TestListener :

# src/test/java/tests/listener/WebDriverListener :

# suiteXml :

A suiteXml is a folder where configuration file is added to load invoke the data and configure the testsuite.

# suiteXml/test-data.xml :

A test-data.xml file contains credentials that is used for system login i.e, baseURL, username and password
and other credentials.

# suiteXml/testNg.xml :

A testNg.xml file is a configuration file that helps in organizing our tests.
It allows to create and handle multiple test classes, define test suites and tests.

# logs :

A logs folder helps us to track and log the test steps.

# reports :

A reports is a folder where each time test execution report is dumped, this is an .html
file which can be viewed via browsers.

# .gitignore :

A git configuration file that excludes specific directory or files from
being included during commits to a git repository.

# pom.xml :

Maven related file used for managing dependency and plugins with in the
project.


