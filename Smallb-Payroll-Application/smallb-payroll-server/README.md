# Smallb Payroll Application Backend

This is the backend portion of the Smallb Payroll Application. Inside this directory are all of the necessary files to run the Smallb Payroll Application REST API. Currently, the API is able to handle 'GET' and 'POST' requests. However, it will soon be able to handle 'PUT' and 'DELETE' requests as well as additional functionality is included.

## Running the Backend

In order to start this server, a build.gradle file has been created. This allows the server to be started using one easy command. Starting the server involves executing the two following commands in a CLI:

```
gradle build
gradle tomcatRunWar
```

Once the server has been started, it can be accessed at this URL: http://localhost:8080/smallb-payroll-server/

## Communicating with the API

After the server has been started, it will begin to accept HTTP requests at the correct URL. The Smallb Payroll API servlet listens at the "/api" location of the server URL. ~~Please see the REST API Documentation in the 'doc/' directory for more information about how to access the API.~~ The REST API documentation has not been completed yet.

## Database Information

~~This project utilizes a remote database hosted by Amazon Web Services. The database is a MySQL database, and connection to the database uses the AWS JDBC connection. Information about the database is included in the 'database.properties' file located in the 'resources/' directory.~~  
Currently, the Database that will be used is unknown. Additional research about how to ensure that the AWS RDS is in the "free tier" is needed to minimize (or eliminate) unnecessary costs.

## Directory Contents

-   [doc](/doc/): Contains the Javadoc files ~~and the REST API Documentation~~
-   [mysql](/mysql/): Contains the MySQL Schema and Test-Data Scripts and an EER Diagram of the 'Smallb_Payroll' Schema
