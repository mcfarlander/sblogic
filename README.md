# sblogic
This project is a sandbox for testing and deploying spring boot services and
servlets to Weblogic. This project was developed with, and can be executed on,
Java 8. It is recommended to use Java 11 and above.

### Java, Eclipse and MacOS 
To recreate the development environment on macOS, install Java 11 (Oracle)
and Eclipse 2019-09 (2020-03 also works). From there, use the Eclipse Marketplace 
to install the weblogic plugin 17.3. **Start with installing the weblogic plugin
before updating eclipse or installing any other plugins.**

Add the server runtime. See the screen shots in the add_weblogic_server 
folder.

After that, add the Spring Boot plugins and any other plugins needed for
development.


# Weblogic
Weblogic is a J2EE server from Oracle. As of mid-2021, the free version is
14.1.1. An Oracle user account is needed to download the jar that will install
the server. It can be installed locally. 

Use the generic (largest) of the downloads. This will include the server, tools
and example domains. Run the install from the command line like java -jar install_jar.jar.
The name of the installer jar will contain the version number.

Once that is accomplished, create a new domain for use with this project. From 
within eclipse, create your domain. When setting up a new server, run the
domain setup wizard. See the screen captures for adding a server, each step
shows the intented result.

The project is maven-enabled. Use the build process to package a WAR. This
can be deployed separately. From Eclipse, deploy as a **virtual application**.
See the screen capture of the deployment.

By conventions, the tomcat-starter should be commented out in the pom. This
will create an odd warning that "wsservercontainer cannot be cast to 
tyrusservercontainer". This dependency is retained but the scope is set to
provided.

### Changing Java Version
If the JRE is changed, there are a number of configuration files that will
need to be updated within the weblogic deployment folder. There are notes on
this on the internet but I found it easier to delete the existing folders and
re-installing the entire weblogic setup. At that point, both weblogic and 
eclipse were using the same JRE.

### Context Root
The default port for weblogic is 7001. To access the console, use
http://localhost:7001/console.

The context root of this application is sblogic. To access, use
http://localhost:7001/sblogic/...

Thymeleaf templates are within the project. If there is a reference
to one, the correct context root will need to be applied to the link.

### Weblogic Logging
The access logs and other domain related logs will be found in
	`<install path>/<domain>/servers/AdminServer.logs`

### Application Logging
The application specific logs will be found starting at the root folder,
	`<install path>/<domain>/<log file path>`
	
# LDAP and Weblogic
There is an free on-line LDAP server that can be used for testing with. Launch
the server and set the parameters with the connection information. See the screen
captures for configuration examples.

Open LDAP service:
https://www.forumsys.com/tutorials/integration-how-to/ldap/online-ldap-test-server/

LDAP Server Information (read-only access):

Server: ldap.forumsys.com  
Port: 389

Bind DN: cn=read-only-admin,dc=example,dc=com
Bind Password: password

All user passwords are password.

You may also bind to individual Users (uid) or the two Groups (ou) that include:

ou=mathematicians,dc=example,dc=com

riemann
gauss
euler
euclid

ou=scientists,dc=example,dc=com

einstein
newton
galieleo
tesla

WebLogic configuration instructions:
https://docs.oracle.com/en/middleware/enterprise-data-quality/12.2.1.3/secure/configuring-weblogic-use-ldap.html#GUID-E64A4A4E-C1ED-4ACE-A936-DFF2CDD9C9E7





