package com.sparta.employeeDataMigration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class StringParserTest {
//647173,Mr.,Milan,F,Krawczyk,M,milan.krawczyk@hotmail.com,04/04/1980,19/01/2012,123681
    //int , str, str, str, str , str,str,                       date,    date,     int



    @Nested
    @DisplayName("Date parser method tests")
    public class dateParserMethodTests {


        @Test
        @DisplayName("Testing data inserted returns a date")
        public void testingDataInsertedReturnsADate() {
            LocalDate expectedDate = LocalDate.of(2022, 11, 01);
            try {
                assertEquals(expectedDate, StringParser.parseDate("01/11/2022"));
            }catch(Exception e){
                fail();
            }
        }

        @Test
        @DisplayName("Assert exception is thrown when not compatible with date type")
        public void assertExceptionIsThrownWhenNotCompatibleWithDateType() {

            Assertions.assertThrows(Exception.class, ()-> StringParser.parseDate("poggers"));
            }

    }
    @Nested
    @DisplayName("Int Parser method tests")
    public class intParserMethodTests {
        @Test
        @DisplayName("id Number returns integers")
        public void idNumberReturnsIntegers() {
            try {
                assertEquals(123, StringParser.parseInt("123"));
            } catch (Exception e) {
                fail();
            }
        }

        @Test
        @DisplayName("id Number parse returns exception when not correct ")
        public void idNumberParseReturnsExceptionWhenNotCorrect() {
            Assertions.assertThrows(Exception.class, () -> StringParser.parseInt("fish >:V"));
        }
    }


}