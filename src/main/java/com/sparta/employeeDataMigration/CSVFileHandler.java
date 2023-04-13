package com.sparta.employeeDataMigration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFileHandler {
    public static List<String> readFile(String filePath) throws FileNotFoundException {

        List<String> result = null; // collect all lines into a list
        try {
            result = Files.lines(Paths.get(filePath))
                    .skip(1) // skip the header line
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result.stream()
                .toList();

    }


}