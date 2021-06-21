# sblogic
This project is a sandbox for testing and deploying spring boot services and
servlets to Weblogic. This project was developed with, and can be executed on,
Java 8. It is recommended to use Java 11 and above.

# Weblogic
Weblogic is a J2EE server from Oracle. As of mid-2021, the free version is
14.1.1. It can be installed locally. Once that is accomplished, create a new
domain for use with this project.

The project is maven-enabled. Use the build process to package a WAR. This
can be deployed separately. From Eclipse, deploy as a **virtual application**.

By conventions, the tomcat-starter should be commented out in the pom. This
will create an odd warning that "wsservercontainer cannot be cast to 
tyrusservercontainer". This dependency is retained but the scope is set to
provided.

### Context Root
The default port for weblogic is 7001. To access the console, use
http://localhost:7001/console.

The context root of this application is sblogic. To access, use
http://localhost:7001/sblogic/...

### Weblogic Logging
The access logs and other domain related logs will be found in the 
<install path>/<domain>/servers/AdminServer.logs directory.

### Application Logging
The application specific logs will be found starting at the root folder,
<install path>/<domain>/<log file path>.
