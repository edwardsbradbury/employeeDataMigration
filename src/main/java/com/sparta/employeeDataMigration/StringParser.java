package com.sparta.employeeDataMigration;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class StringParser {
    
    
    public static int parseInt(String epic) throws Exception {
        String regex = "\\d+";
        if (epic == null || epic.length() <=0){
            throw new Exception("Invalid Input");

        }if (Pattern.matches(regex, epic) == false){
            throw new Exception("Invalid Input");
        }
        return Integer.valueOf(epic);
    }




    public static LocalDate parseDate(String poggers) throws Exception {
        //04/04/1980
        String regex = "\\d{2}/\\d{2}/\\d{4}";
        if(poggers == null || poggers.length() <= 0 || !poggers.matches(regex)){
            throw new Exception("Invalid date format");
        }else{
            String[] segments = poggers.split("/");
            return LocalDate.of(parseInt(segments[2]), parseInt(segments[1]), parseInt(segments[0]));
        }
    }
    
    //Parser takes employee Array and turns it into an array per row

    /**
     * String[] = {"name, other attribute, salary","name, other attribute, salary"}
     * output
     * String[] (one employee)= {"name", "other attribute", "salary"}
     *
     * What if we just used this class specifically for parsing from string
     * to employee specific properties using static methods ex:
     * public static int parseInteger(String employeeNumber)throws SomeKindOfException{
     *     if(employeeNumber == null) throw new SomeKindOfException();
     *     try{
     *         return Integer.parseInt(employeeNumber);
     *     }catch(Exception e){
     *         throw new SomeKindOfException();
     *     }
     * }
     *
     * and then we could have a method in the Employee class that creates the employee object
     * and calls these methods to get the right data types from the Strings we pass through.
     */



}
