package com.sparta.employeeDataMigration.dataAccessObject;

import com.sparta.employeeDataMigration.App;
import com.sparta.employeeDataMigration.Employee;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements DAOInterface<Employee> {

  private static final Logger logger = LogManager.getLogger(App.class);

  List<Employee> allEmployees;

  @Override
  public int insert(Employee newRow) {
    if (newRow == null) {
      return 0;
    }
    int result = 0;
    String insertStatement = "INSERT INTO employees (employeeID, prefix, firstName, middleInitial, lastName, gender, email, birthDate, joinDate, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement statement = ConnectionProvider.getConnection().prepareStatement(insertStatement)) {
      statement.setInt(1, newRow.getEmployeeID());
      statement.setString(2, newRow.getPrefix());
      statement.setString(3, newRow.getFirstName());
      statement.setString(4, newRow.getMiddleInitial());
      statement.setString(5, newRow.getLastName());
      statement.setString(6, newRow.getGender());
      statement.setString(7, newRow.getEmail());
      statement.setDate(8, newRow.getBirthDate().toString());
      statement.setDate(9, newRow.getJoinDate().toString());
      statement.setInt(10, newRow.getSalary());
      result = statement.executeUpdate();
    } catch (SQLException e) {
      logger.log(Level.ERROR, "SQL insertion operation failed", e);
    } catch (Exception e) {
      logger.log(Level.ERROR, "Something went wrong in EmployeeDAO.insert() method", e);
    }
    return result;
  }

  @Override
  public List<Employee> getAll() {
    if (allEmployees  != null) {
      return allEmployees;
    } else {
      String selectAll = "SELECT * FROM employees";
      try (Statement statement = ConnectionProvider.getConnection().createStatement()) {
        ResultSet resultSet = statement.executeQuery(selectAll);
        if (resultSet != null) {
          allEmployees = new ArrayList<>();
          while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getDate(8).toLocalDate(), resultSet.getDate(9).toLocalDate(), resultSet.getInt(10));
            allEmployees.add(employee);
          }
        }
      } catch (SQLException e) {
        logger.log(Level.ERROR, "SQL select operation failed", e);
      } catch (Exception e) {
        logger.log(Level.ERROR, "Something went wrong in EmployeeDAO.getAll() method", e);
      }
      return allEmployees;
    }
  }
}
