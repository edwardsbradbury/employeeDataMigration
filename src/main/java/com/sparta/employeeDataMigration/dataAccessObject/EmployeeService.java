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

//  public String displayResultOfReadCSV() {
//    return "Clean records: " + getNumCleanRecords() + "\n"
//        + "Duplicate records: " + getNumDuplicateRecords() + "\n";
//  }

  public int getTotalNumEmployees() {
    return employeeDAO.getAll().size();
  }

//  public int getNumCleanRecords() {
//    return employeeDAO.getAll()
//        .stream()
//        .filter(employee -> )
//        .size();
//  }
//
//  public int getNumDuplicateRecords() {
//    return employeeDAO.getAll()
//        .stream()
//        .filter(employee -> )
//        .size();
//  }

//  public int getNumCorruptRecords() {
//    return employeeDAO.getAll()
//        .stream()
//        .filter(employee -> )
//        .size();
//  }

}
