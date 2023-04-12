package com.sparta.employeeDataMigration.dataAccessObject;

public class EmployeeService {

  private EmployeeDAO employeeDAO;

  public EmployeeService(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public int getTotalNumEmployees() {
    return employeeDAO.getAll().size();
  }



}
