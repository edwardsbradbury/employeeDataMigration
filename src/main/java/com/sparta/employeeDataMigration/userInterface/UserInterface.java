package com.sparta.employeeDataMigration.userInterface;

import com.sparta.employeeDataMigration.dataAccessObject.EmployeeDAO;
import com.sparta.employeeDataMigration.dataAccessObject.EmployeeService;

import java.util.Scanner;

public class UserInterface implements UserInteractions {

private Scanner scan;
private String options;

private EmployeeService employeeService = new EmployeeService(new EmployeeDAO());

  public UserInterface() {

    System.out.println(employeeService.displayResultOfReadCSV());

    this.scan = new Scanner(System.in);
    this.options = "\nEnter number and return to choose an option:\n1) List clean, unique records\n2) List duplicate records\n3) List records with missing or invalid fields\n4) Quit";
    int selectedOption = 0;

    do {

      selectedOption = getOption(this.scan);

      switch (selectedOption) {
        case 1:
          System.out.println(employeeService.displayAllEmployees());
          break;
        case 2:
          System.out.println(employeeService.getNumCleanRecords());
          break;
        case 3:
          System.out.println(employeeService.getNumCorruptRecords());
          break;
      }

    } while (selectedOption != 4);

    this.scan.close();
    System.out.println("Goodbye");

  }

  @Override
  public int getOption(Scanner scan) {

    int option = 0;
    boolean optionValid = false;

    do {
      System.out.println(options);
      while (!scan.hasNextInt()) {
        System.out.println("\nOption not recognised");
        System.out.println(options);
        scan.next();
      }
      option = scan.nextInt();
      if (option < 1 || option > 4) {
        System.out.println("\nOption not recognised");
      } else {
        optionValid = true;
      }
    } while (!optionValid);

    return option;
  }
}
