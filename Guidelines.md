# Maven & pom.xml

## Dependencies and plugins

### Dependencies

Dependencies provide the libraries your project needs to compile, test, and run.

### Plugins

Plugins handle the build process, such as compiling code, packaging artifacts, and running tests.

Some of the dependencies/plugins we use in this project are:

MariaDB (https://repo1.maven.org/maven2/org/mariadb/jdbc/mariadb-java-client/2.5.3/)

Javax Servlet (https://repo.maven.apache.org/maven2/javax/servlet/javax.servlet-api/3.1.0/)

Jetty (https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-maven-plugin/11.0.24/)


## Why do we need to import .jar files into a Maven project

Maven projects typically rely on dependencies declared in the `pom.xml` file, which are automatically downloaded from repositories. Importing a `.jar` file into a Maven project is necessary when you want to use an external library or dependency that is not available in a public Maven repository (like Maven Central). 

When importing a `.jar` file into your Maven project, you can create a `lib/` directory in the root directory and place the `.jar` file there. Then add the dependency to your pom.xml using the system scope.

## Servlets

Servlets are Java classes that handle HTTP requests and responses, typically used to build dynamic web applications. Servlets a core part of Java's server-side programming model and need to be enabled in a Maven project.