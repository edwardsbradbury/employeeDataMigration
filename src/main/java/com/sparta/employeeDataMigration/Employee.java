package com.sparta.employeeDataMigration;

import java.time.LocalDate;

public class Employee {

    //Emp ID,Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary

    //Employee object making  0307
    //>:V write tests first!!!! TDD GRRRRRRRRRR
    private int employeeID;
    private String prefix;

    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String email;
    private LocalDate birthDate;
    private LocalDate joinDate;
    private int salary;

    public Employee(String rawData)throws Exception{
        if(rawData == null) throw new Exception("Invalid employee data");
        String[] rawDataArray = rawData.split(",");
        if(rawDataArray.length != 10) throw new Exception("Invalid employee data");

        this.employeeID = StringParser.parseInt(rawDataArray[0]);
        this.prefix = rawDataArray[1];
        this.firstName = rawDataArray[2];
        this.middleInitial = rawDataArray[3];
        this.lastName = rawDataArray[4];
        this.gender = rawDataArray[5];
        this.email = rawDataArray[6];
        this.birthDate = StringParser.parseDate(rawDataArray[7]);
        this.joinDate = StringParser.parseDate(rawDataArray[8]);
        this.salary = StringParser.parseInt(rawDataArray[9]);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public int getSalary() {
        return salary;
    }




    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }




}