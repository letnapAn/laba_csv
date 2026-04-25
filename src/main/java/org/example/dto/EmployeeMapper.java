package org.example.dto;

import org.example.dto.csv.CsvEmployee;
import org.example.entity.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeMapper {

    private final Map<String, Division> divisionCache;

    public EmployeeMapper() {
        this.divisionCache = new ConcurrentHashMap<>();
    }

    public Employee toEntity(CsvEmployee dto) {
        Division division = divisionCache.computeIfAbsent(dto.getDivisionName(), Division::new);
        return new Employee(dto.getId(), dto.getName(), dto.getGender(), dto.getBirthDate(), division, dto.getSalary());
    }
}