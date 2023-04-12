package com.sparta.employeeDataMigration.dataAccessObject;

import java.io.IOException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {
  private static Connection connection = null;
  private static final String URL = "jdbc:mysql://localhost:3306/spartaglobal?serverTimerzone=GMT";

  private static Properties properties = new Properties();

  private ConnectionProvider() {

  }

  public static Connection getConnection(){
    if (connection == null) {
      try {
        properties.load(new FileReader("src/main/resources/login.properties"));
        connection = DriverManager.getConnection(URL, properties.getProperty("username"), properties.getProperty("password"));
      } catch (IOException e) {
        e.printStackTrace();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
    return connection;
  }

  public static void closeConnection() {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
