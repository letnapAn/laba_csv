package org.example;

import org.example.dto.csv.CsvEmployee;
import org.example.dto.EmployeeReader;
import org.example.dto.EmployeeMapper;


import org.example.entity.*;
import java.util.List;
import java.util.stream.Collectors;

public class FacadeService {

    private final EmployeeReader reader;
    private final EmployeeMapper mapper;

    public FacadeService(EmployeeReader reader, EmployeeMapper mapper) {
        this.reader = reader;
        this.mapper = mapper;
    }

    public List<Employee> loadEmployees(String resourcePath) {
        List<CsvEmployee> dtos = reader.readData(resourcePath);
        return dtos.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }
}