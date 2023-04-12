package com.sparta.employeeDataMigration.dataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements DAOInterface<Employee> {

  @Override
  public int insert(Employee newRow) {
    return 0;
  }

  @Override
  public List<Employee> getAll() {
    List<Employee> allEmployees = new ArrayList<>();
    try {
      Statement statement = ConnectionProvider.getConnection().createStatement();
      ResultSet resultSet = statement.executeQuery(selectAll);
      if (resultSet != null) {
        while (resultSet.next()) {
          Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getDate(5).toLocalDate());
          allEmployees.add(employee);
        }
      } else {
        System.out.println("No records in the table");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
//      ConnectionProvider.closeConnection();
    }
    return allEmployees;
  }
}
