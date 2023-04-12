package com.sparta.employeeDataMigration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTests {
    @Nested
    @DisplayName("Test constructor")
    public class TestConstructor{


        @Test
        @DisplayName("Passing a string of raw employee data will create an employee object")
        public void passingAStringOfRawEmployeeDataWillCreateAnEmployeeObject(){
            Employee employee;
            assertDoesNotThrow(() ->new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,19/01/2012,123681"));
            try{
                assertEquals(Employee.class, new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,19/01/2012,123681").getClass());
            }catch(Exception e){
                fail();
            }
        }

        @Test
        @DisplayName("Passing a string of employee data will cause an error to be thrown when extra fields are present")
        public void passingAStringOfEmployeeDataWillCauseAnErrorToBeThrownWhenExtraFieldsArePresent(){
            assertThrows(Exception.class, ()->new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,19/01/2012,123681,k"));
        }
        @Test
        @DisplayName("Passing a string of employee data will cause an error to be thrown when fields are missing")
        public void passingAStringOfEmployeeDataWillCauseAnErrorToBeThrownWhenFieldsAreMissing(){
            assertThrows(Exception.class, ()->new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,19/01/2012"));
        }

        @Test
        @DisplayName("Passing a string of employee data will cause an error to be thrown when id is invalid")
        public void passingAStringOfEmployeeDataWillCauseAnErrorToBeThrownWhenIDIsInvalid(){
            assertThrows(Exception.class, ()->new Employee("64717t3,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,19/01/2012,123681"));
        }
        @Test
        @DisplayName("Passing a string of employee data will cause an error to be thrown when salary is invalid")
        public void passingAStringOfEmployeeDataWillCauseAnErrorToBeThrownWhenSalaryIsInvalid(){
            assertThrows(Exception.class, ()->new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,19/01/2012,1236f81"));
        }
        @Test
        @DisplayName("Passing a string of employee data will cause an error to be thrown when birth date is invalid")
        public void passingAStringOfEmployeeDataWillCauseAnErrorToBeThrownWhenBirthDateIsInvalid(){
            assertThrows(Exception.class, ()->new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/041980,19/01/2012,123681"));
        }
        @Test
        @DisplayName("Passing a string of employee data will cause an error to be thrown hire date is invalid")
        public void passingAStringOfEmployeeDataWillCauseAnErrorToBeThrownWhenHireDateIsInvalid(){
            assertThrows(Exception.class, ()->new Employee("647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,19/q1/2012,123681"));
        }
    }






    @Nested
    @ExtendWith(EmployeeParameterResolver.class)
    @DisplayName("Test Getters")
    public class TestGetters{
        /*647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,19/01/2012,123681*/
        @Test
        @DisplayName("testing the id is gottten ")
        public void testingTheIDIsGotten(Employee employee) {
            assertEquals(647173,employee.getEmployeeID());
        }
            
        @Test
        @DisplayName("The first name is gotten ")
        public void theFirstNameIsGotten(Employee employee) {
            assertEquals("Milan",employee.getFirstName());
            }

        @Test
        @DisplayName("the Middle initial is retuned")
        public void methodName(Employee employee) {
            assertEquals("F",employee.getMiddleInitial());
            }

        @Test
        @DisplayName("Last name is returned")
        public void lastNameIsReturned(Employee employee) {
            assertEquals("Krawczyk", employee.getLastName());
        }
        @Test
        @DisplayName("Gender is returned")
        public void genderIsReturned(Employee employee) {
            assertEquals("M", employee.getGender());
            }

        @Test
        @DisplayName("The Email is returned")
        public void theEmailIsReturned(Employee employee) {
            assertEquals("milan.krawczyk@hotmail.com",employee.getEmail());
            }

        @Test
        @DisplayName("The birth date is properly returned for employee")
        public void theBitchDateIsProperlyReturnedForEmployee(Employee employee){
                assertEquals(LocalDate.of(1980, 04, 04), employee.getBirthDate());
        }

        @Test
        @DisplayName("The join date is properly returned for employee")
        public void joinDateIsProperlyReturnedFromEmployeeObject(Employee employee){
                assertEquals(LocalDate.of(2012, 01, 19), employee.getJoinDate());
        }

        @Test
        @DisplayName("The salary is returned")
        public void correctSalaryReturnedForEmployeeObject(Employee employee){
            assertEquals(123681, employee.getSalary());
        }
    }


    /*647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,19/01/2012,123681*/

    @Nested
    @DisplayName("Test Setters")
    @ExtendWith(EmployeeParameterResolver.class)
    public class TestSetters{
        @Test
        @DisplayName("Testing the id can be changed")
        public void testingTheIdCanBeChanged(Employee employee) {
            int newID = 42069;
            //epic
            employee.setEmployeeID(newID);
            assertEquals(newID, employee.getEmployeeID());
        }

        @Test
        @DisplayName("Updating the prefix will reflect the change in the object?")
        public void updatingThePrefixWillReflectTheChangeInTheObject(Employee employee){
            String newPrefix = "Dr.";
            employee.setPrefix(newPrefix);
            assertEquals(newPrefix, employee.getPrefix());
        }
        @Test
        @DisplayName("Updating the first name will reflect the change in the object?")
        public void updatingTheFirstNameWillReflectTheChangeInTheObject(Employee employee){
            String newFirstName = "Sahan";
            employee.setFirstName(newFirstName);
            assertEquals(newFirstName, employee.getFirstName());
        }

        @Test
        @DisplayName("Middle initial will change")
        public void middleInitialWillChange(Employee employee) {
            String newthing = "M";
            employee.setMiddleInitial(newthing);
            assertEquals(newthing,employee.getMiddleInitial());
            }

        @Test
        @DisplayName("Gender will be changed")
        public void genderWillBeChanged(Employee employee) {
            String newthing = "M";
            employee.setGender(newthing);
            assertEquals(newthing, employee.getGender());
            }

        @Test
        @DisplayName("Updating the last name will reflect the change in the object?")
        public void updatingTheLastNameWillReflectTheChangeInTheObject(Employee employee){
            String newLastName = "Seneviratne";
            employee.setLastName(newLastName);
            assertEquals(newLastName, employee.getLastName());
        }

        @Test
        @DisplayName("Testing email can be changed")
        public void testingEmailCanBeChanged(Employee employee) {
            String newthing = "sahan@poggers.com";
            employee.setEmail(newthing);
            assertEquals(newthing,employee.getEmail());
            }



        @Test
        @DisplayName("Updating the salary will reflect change in the object?")
        public void updatingTheSalaryWillReflectChangeInObject(Employee employee){
            int newSalary = 42069;
            employee.setSalary(newSalary);
            assertEquals(newSalary, employee.getSalary());
        }

        @Test
        @DisplayName("Updating the birth date will reflect the change in the object")
        public void updatingTheBirthDateWillReflectChangeInTheObject(Employee employee){
            LocalDate newDate = LocalDate.of(1985, 04, 20);
            employee.setBirthDate(newDate);
            assertEquals(newDate, employee.getBirthDate());
        }

        @Test
        @DisplayName("Updating the join date will reflect the change in the object")
        public void updatingTheJoinDateWillReflectChangeInTheObject(Employee employee){
            LocalDate newDate = LocalDate.of(1985, 04, 20);
            employee.setJoinDate(newDate);
            assertEquals(newDate, employee.getJoinDate());
        }
    }





}
