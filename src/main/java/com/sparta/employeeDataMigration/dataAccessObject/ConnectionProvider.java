package com.sparta.employeeDataMigration.dataAccessObject;

import com.sparta.employeeDataMigration.App;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {

  private static final Logger logger = LogManager.getLogger(App.class);
  private static Connection connection = null;
  private static final String URL = "jdbc:mysql://localhost:3306/employeemigration?serverTimerzone=GMT";

  private static Properties properties = new Properties();

  private ConnectionProvider() {

  }

  public static Connection getConnection(){
    if (connection == null) {
      try {
        properties.load(new FileReader("src/main/resources/login.properties"));
        connection = DriverManager.getConnection(URL, properties.getProperty("username"), properties.getProperty("password"));
      } catch (IOException e) {
        logger.log(Level.ERROR, "Failed to read login.propertiws file", e);
      } catch (SQLException e) {
        logger.log(Level.ERROR, "Failed to connect to SQL database", e);
      } catch (Exception e) {
        logger.log(Level.ERROR, "Something went wrong in ConnectionProvider.getConnection method", e);
      }
    }
    return connection;
  }

  public static void closeConnection() {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        logger.log(Level.ERROR, "Failed to close the database connection", e);
      } catch (Exception e) {
        logger.log(Level.ERROR, "Something went wrong in ConnectionProvider.closeConnection method", e);
      }
    }
  }
}
