package com.sparta.employeeDataMigration;


import java.io.FileNotFoundException;

import com.sparta.employeeDataMigration.userInterface.UserInterface;


public class App
{

    private static final String FILE_PATH = "src/main/resources/EmployeeRecords.csv";
    public static void main( String[] args )
    {

        //testing

        try {
            for (String string : CSVFileHandler.readFile(FILE_PATH))
                System.out.println(string);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        UserInterface ui = new UserInterface();
    }
}
