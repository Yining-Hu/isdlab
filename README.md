# Introduction to Software Development (ISD)

This repo provides a Maven version of the ISD labs for VS Code users. 

Make sure you first install:

- Java JDK (https://www.oracle.com/au/java/technologies/downloads/)
- Maven (https://maven.apache.org/download.cgi) Select the **binary version** not Source

To Run The Project:

Open 2 terminals, side by side in VsCode:

Every time you make a change, run:

`mvn package`

In the other terminal, just run the following & leave it open for as long as you are developing:
`mvn jetty:run`

Then, open a web browser & visit: `http://localhost:8080`

To run unit tests: `mvn test`

## Help Installing Maven

### Mac Users

Macos Users will need to edit their bash_profile file in ~/.bash_profile

Please add the following (Update the path to be wherever you downloaded the maven folder):

```
export M2_HOME="/Users/jack/Downloads/apache-maven-3.6.3"
PATH="${M2_HOME}/bin:${PATH}"
export PATH
```

You can confirm maven was succesfully installed by running `mvn` in your terminal.

### Windows Users

After installing Maven, search for environment variables in windows. This will open a dialogue like so:

![Alt text](images/env.PNG?raw=true 'Environment Variables')

Click the new button under system variables & add one called MAVEN_HOME with a link to the downloaded zip file:

![Alt text](images/systemvar.PNG?raw=true 'Environment Variables')

Find the PATH Variable under user variables & click edit. On the next screen, add a new entry with the value `%MAVEN_HOME%\bin`:

![Alt text](images/uservar.PNG?raw=true 'User Variables')

Close all the menus, reload a terminal window & you can confirm maven was succesfully installed by running `mvn` in your terminal.

## Connect with a database
You need to set up a local database. In this project, we are using the MariaDB, a popular open source relational databases. MariaDB is included as a dependency on pom.xml. The driver name is ```org.mariadb.jdbc.Driver```, and the default url is ```jdbc:mariadb://<host>:<port>/<database>```

## Enable Servlets in a Maven project

### Add the Servlet API dependency

Servlets rely on the Java Servlet API, which is not part of the standard Java SE library. You need to include the Servlet API as a dependency in your Maven project.

```
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>
```

### Configure the project structure

A Servlet-based web application requires a specific directory structure (e.g., src/main/webapp for web resources like HTML, JSP, and WEB-INF).

```
src/
  main/
    java/       # Java source files (e.g., Servlets)
    resources/  # Configuration files (e.g., properties, XML)
    webapp/     # Web resources (e.g., HTML, JSP, CSS, JS)
      WEB-INF/  # Configuration files (e.g., web.xml)
```

### Set up a Servlet container

Servlets run inside a Servlet container (e.g., Apache Tomcat, Jetty). You need to configure your project to work with a Servlet container for deployment and testing. Add the below code in your pom.xml.

```
<plugin>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-maven-plugin</artifactId>
    <version>${jettyVersion}</version>
    <configuration>
        <httpConnector>
            <port>8080</port>
        </httpConnector>
    </configuration>
</plugin>
```

### Write and configure Servlets

Create Servlet classes and configure them according to the workshop materials on Canvas.

# Acknowledgement
This project is based on the original repo: https://github.com/jiak1/ISDAutLab-VsCode. Thanks to them for their work!
