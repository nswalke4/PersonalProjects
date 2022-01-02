# Smallb Payroll Application

This is the project repository for the full-stack Smallb Payroll Application. The goal of this application is to publish and hopefully be an application that small business owners might utilize to help with their bookkeeping.

## [Web Application](/smallb-payroll/)

_The web application portion of this project has not been started yet._

#### Development Tools

-   Javascript Language
-   ReactJS Library
-   NodeJS Engine
-   npm Package Manager
-   "Create React App" npm Command
-   Cognito AWS User Authentication
-   AWS EC2 Instance for Application Hosting

## [Backend](/smallb-payroll-server/)

_The backend of this project has been "completed", but there are additional API methods that will be added at a later date_
The backend of this project is essentially the "middle-man". This section of the project is responsible for communicating with the web application and the database. This section of the project's responsibilites are as follows: 1. Receive HTTP Requests from the web application 2. Parse the information received to ensure that the requested action is valid and contains the necessary components to complete the action 3. Communicate with the database to gather (or manipulate) the data as requested by the web application 4. Parse the received information from the database into a response to send back to the web application 5. Send the response to the web application's request

#### Development Tools

-   Java 11 Language
-   HttpServlet Library
-   JSON Library
-   Gradle for Code Execution
-   Tomcat Extension for Gradle for Servlet Execution
-   MySQL Database Language
-   AWS Aurora RDS for Database Management
-   AWS EC2 Instance for Servlet Hosting
