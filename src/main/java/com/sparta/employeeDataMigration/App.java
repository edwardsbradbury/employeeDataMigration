package com.sparta.employeeDataMigration;

import java.io.FileNotFoundException;

public class App
{
    public static void main( String[] args ) throws FileNotFoundException {

        //testing csv reader, just remove if u want

        for (String string : CSVFileHandler.readFile()){

            System.out.println(string);
        }
    }
}
