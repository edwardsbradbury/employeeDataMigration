package com.sparta.employeeDataMigration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVFileHandler {




  public static List<String> readFile(String filePath) throws FileNotFoundException {


    List<String> result = new ArrayList<>();

    try (Scanner scanner = new Scanner(new File(filePath));){
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        result.add(line);
      }

      scanner.close();
      return result;

    } catch (IOException e){
      throw new FileNotFoundException(e.toString());
    }


  public static List<String> readFile() throws FileNotFoundException {
    return new ArrayList<String>();
//      throw new FileNotFoundException();

  }


}
