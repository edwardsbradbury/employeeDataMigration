package com.sparta.employeeDataMigration.userInterface;

import java.util.Scanner;

public interface UserInteractions {

  public int getOption(Scanner scan);

  public void listCleanRecords();

  public void listDuplicateRecords();

  public void listCorruptedRecords();
}
