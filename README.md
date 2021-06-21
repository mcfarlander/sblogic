# sblogic
This project is a sandbox for testing and deploying spring boot services and
servlets to Weblogic. 

# Weblogic
Weblogic is a J2EE server from Oracle. As of mid-2021, the free version is
14.1.1. It can be installed locally. Once that is accomplished, create a new
domain for use with this project.

The project is maven-enabled. Use the build process to package a WAR. This
can be deployed separately. From Eclipse, deploy as a virtual application.

## Weblogic Logging
The access logs and other domain related logs will be found in the 
<install path>/<domain>/servers/AdminServer.logs directory.

## Application Logging
The application specific logs will be found starting at the root folder,
<install path>/<domain>/<log file path>.
