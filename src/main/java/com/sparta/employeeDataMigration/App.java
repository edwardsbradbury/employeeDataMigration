package com.sparta.employeeDataMigration;

import java.io.FileNotFoundException;

public class App
{
    public static void main( String[] args )
    {

        //testing

        try {
            for (String string : CSVFileHandler.readFile())
                System.out.println(string);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
