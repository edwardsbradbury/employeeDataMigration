package com.sparta.employeeDataMigration.userInterface;

import java.util.Scanner;

public class UserInterface implements UserInteractions {

private Scanner scan;
private String options;

  public UserInterface() {

    this.scan = new Scanner(System.in);
    this.options = "\nEnter number and return to choose an option:\n1) List clean, unique records\n2) List duplicate records\n3) List records with missing or invalid fields\n4) Quit";
    int selectedOption = 0;

    do {

      selectedOption = getOption(this.scan);

      switch (selectedOption) {
        case 1:
          System.out.println("Listing clean, unique records");
          break;
        case 2:
          System.out.println("Listing duplicate records");
          break;
        case 3:
          System.out.println("List records with missing or invalid fields");
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

  @Override
  public void listCleanRecords() {

  }

  @Override
  public void listDuplicateRecords() {

  }

  @Override
  public void listCorruptedRecords() {

  }
}
