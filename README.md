# Employee CSV Data Migration Project
This project aims to migrate employee data from a CSV file to a relational database using JDBC. It also demonstrates good programming practices in OOP, SOLID, design patterns, testing, and logging.

A Sparta Academy (Java Automation Engineers stream) project by Christian Bitca, Sahan Seneviratne, Ed Bradbury, Marcella Chessa, Rafael Lopes, Liam Richardson and Nicholas Thom.

Built using Java JDK 17, with JUnit 5 unit tests and Log4J2 logging.

## Phase 1
- Import the project into your preferred IDE.
- Import the EmployeeRecords.csv file into the src/main/resources directory of the project.
- Run the Main class to start the application.
- The application will read the CSV file, parse it, and populate objects. Any corrupt or duplicated data will be added to a separate collection for further analysis.
- The application will display the results of reading the file, including how many unique, clean records there are, how many duplicates, how many records with missing
fields, and the questionable records.
- Contains classes used to model database structure and define CRUD methods/operations
- The application will also write the clean data to a collection.
- Use the provided EmployeeRecords.csv for your testing, and create your own test files to help with your JUnit tests.
- Contains classes used to handle user interactions (input and output)

## Phase 2
- Create a MySQL database and configure the connection settings in a properties file.
- Run the SQL statements in the employee.sql file to create the necessary table in the database.
- Implement the DAO pattern to persist the clean data to the database.
- Write code to retrieve individual records from the database.
- Run the Main class to test the persistence to the database.

## Testing
The project includes JUnit tests in the directory. You can run the tests using your preferred IDE

## Conclusion
This project demonstrates the importance of using good programming practices in data migration projects, such as OOP, SOLID, design patterns, testing, and logging. By following these practices, we can ensure that only clean data is transferred and that the migration process is efficient and reliable.

