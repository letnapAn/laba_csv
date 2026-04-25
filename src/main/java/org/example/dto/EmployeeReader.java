package org.example.dto;

import org.example.dto.csv.CsvEmployee;

import java.util.List;

public interface EmployeeReader {
    List<CsvEmployee> readData(String resourcePath);
}