# Employee CSV Data Migration Project

A Sparta Academy (Java Automation Engineers stream) project by Christian Bitca, Ed Bradbury, Marcella Chessa, Rafael Lopes, Liam Richardson, Sahan Seneviratne, and Nicholas Thom.

Built using Java JDK 17, with JUnit 5 unit tests and Log4J2 logging.

## Project Requirements

### Overall Goals

- To read data from a .csv file (provided), parse it, populate objects and add to a collection.
- To efficiently write the data from the objects to a relational database using JDBC.
- To demonstrate good programming practices in OOP, SOLID, design patterns, testing, logging, etc.

### Phase 1 - Initial Reading and Cleaning

Create a new project and write code to read data from an Employee CSV file. \
As it is read in, add each record read to a new object of a suitable class and then add those objects to a collection. \
Any corrupt or duplicated data should be added to a separate collection for further analysis.
Write tests to ensure data is being managed correctly. \
Consider which date class would be best to use for the date fields - there is one in java.util and another in java.sql. \
Provide a simple user interface to display the results of reading the file - how many unique, clean records there are, how many duplicates, how many records with missing fields, possibly display the questionable records. \
User the provided EmployeeRecords.csv for your testing and optionally create your own test files to help with your JUnit tests.


### Phase 2 - Persist to Database

Write the SQL statements to create a table and to persist data to that table. \
If the table exists, it will need to be dropped first. \
Install the drivers for the database to be used (MySQL) and create a connection. \
Create a data access object (DAO pattern) to persist the data to the database. \
Persist employee records and write code to retrieve individual records from the database.

## Project Structure

### Packages

#### com.sparta.employeeDataMigration

Parent package with general files.

#### .dataAccessObject

Contains classes used to model database structure, connect to the database and handle CRUD operations

#### .userInterface

Contains classes used to handle user interactions (input and output)
