package com.sparta.employeeDataMigration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CSVHandlerTests {

  @Test
  @DisplayName("Test that the readFile method returns a List of string if the CSV file is found")
  void testReadFileReturnsListOfStrings() {
    assertThat(CSVFileHandler.readFile(), is(instanceOf(List.class)));
    assertThat((List<?>) CSVFileHandler.readFile(), everyItem(is(instanceOf(String.class))));
  }

  @Test
  @DisplayName("Test that the readFile method throws an exception if file not found")
  void testReadFileThrowsExceptionIfFileNotFound() {
    Assertions.assertThrows(FileNotFoundException.class, () -> CSVFileHandler.readFile());
  }

}
