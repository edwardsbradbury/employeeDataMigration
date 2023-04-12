package com.sparta.employeeDataMigration;

public class EmployeeParser {
    //Parser takes employee Array and turns it into an array per row

    /**
     * String[] == {"name, other attribute, salary","name, other attribute, salary"}
     *
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
    public String[] employeeParser(String[] employeeData){
        for(String employee : employeeData){

        }

        return employeeData;

    }



}
