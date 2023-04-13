package com.sparta.employeeDataMigration.dataAccessObject;

import com.sparta.employeeDataMigration.Employee;

import java.util.List;

public class EmployeeService {

  private EmployeeDAO employeeDAO;

  public EmployeeService(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  private String formatEmployeeForOutput(Employee employee) {
    String appendThis = "" + employee.getEmployeeID() +
        ": " + employee.getPrefix() +
        " " + employee.getFirstName() +
        " " + employee.getMiddleInitial() +
        " " + employee.getLastName() +
        "\n" +
        "Gender: " + employee.getGender() +
        "\n" +
        "D.O.B: " + employee.getBirthDate() +
        "Email: " + employee.getEmail() +
        "Date joined: " + employee.getJoinDate() +
        "Salary: £" + employee.getSalary() + "\n\n";
    return appendThis;
  }

  // Gets all employees from the database and returns  a string representation of all the records
  // for human readable output
  public String displayAllEmployees() {
    List<Employee> allEmployees = employeeDAO.getAll();
    if (allEmployees == null || allEmployees.size() < 1) {
      return "There are no employee records in the database.";
    } else {
      String outputString = "The following are all the employee records created from your CSV file:\n";
      for (Employee anEmployee : allEmployees) {
        outputString = outputString.concat(formatEmployeeForOutput(anEmployee));
      }
      return outputString;
    }
  }

//  Method to return a string telling the number of clean records created and number of duplicates
//  public String displayResultOfReadCSV() {
//    return "Clean records: " + getNumCleanRecords() + "\n"
//        + "Duplicate records: " + getNumDuplicateRecords() + "\n";
//  }


  public String getTotalNumEmployees() {
    return "Total number of employee records: " + employeeDAO.getAll().size();
  }

//  INCOMPLETE method to return a string saying how many records are clean
//  public String getNumCleanRecords() {
//      int numRecs = employeeDAO.getAll()
//        .stream()
//        .filter(employee -> )
//        .size();
//      return "Number of clean, unique records: " + numRecs;
//  }

//  INCOMPLETE method to return a string saying how many records are duplicates
//  public String getNumDuplicateRecords() {
//      int numRecs = employeeDAO.getAll()
//        .stream()
//        .filter(employee -> )
//        .size();
//      return "Number of duplicate records: " + numRecs;
//  }

//  INCOMPLETE method to return a string saying how many records are corrupted
//  public String getNumCorruptRecords() {
//    int numRecs =employeeDAO.getAll()
//        .stream()
//        .filter(employee -> )
//        .size();
//    return "Number of corrupted records: " + numRecs;
//  }

}
