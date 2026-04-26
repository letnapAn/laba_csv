package org.example.dto.csv;

import org.example.dto.csv.CsvEmployee;
import org.example.dto.csv.CsvEmployeeReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CsvEmployeeReader Tests")
class CsvEmployeeReaderTest {

    private CsvEmployeeReader reader;

    @BeforeEach
    void setUp() {
        reader = new CsvEmployeeReader();
    }

    @Test
    @DisplayName("Should read CSV file and return list of employees")
    void readEmployees_shouldReturnNonEmptyList() {
        // When
        List<CsvEmployee> employees = reader.readData("foreign_names.csv");

        // Then
        assertNotNull(employees);
        assertFalse(employees.isEmpty());
    }

    @Test
    @DisplayName("Should parse all fields correctly from CSV")
    void readEmployees_shouldParseAllFieldsCorrectly() {
        // When
        List<CsvEmployee> employees = reader.readData("foreign_names.csv");

        // Then
        CsvEmployee firstEmployee = employees.get(0);
        assertEquals(28281, firstEmployee.getId());
        assertEquals("Aahan", firstEmployee.getName());
        assertEquals("Male", firstEmployee.getGender());
        assertNotNull(firstEmployee.getBirthDate());
        assertTrue(firstEmployee.getSalary() > 0);
        assertNotNull(firstEmployee.getDivisionName());
    }

    @Test
    @DisplayName("Should convert date from String to LocalDate")
    void readEmployees_shouldConvertDateCorrectly() {
        // When
        List<CsvEmployee> employees = reader.readData("foreign_names.csv");

        //System.out.println(employees.get(3));

        // Then
        CsvEmployee employee = employees.get(0);
        assertNotNull(employee.getBirthDate());
        System.out.println(employee.getBirthDate());
        assertInstanceOf(LocalDate.class, employee.getBirthDate());
    }

    @Test
    @DisplayName("Should convert salary from String to double")
    void readEmployees_shouldConvertSalaryToDouble() {
        // When
        List<CsvEmployee> employees = reader.readData("foreign_names.csv");

        // Then
        CsvEmployee employee = employees.get(0);
        assertEquals(4800.0, employee.getSalary());
    }

    @Test
    @DisplayName("Should read all divisions from CSV")
    void readEmployees_shouldReadAllDivisions() {
        // When
        List<CsvEmployee> employees = reader.readData("foreign_names.csv");

        // Then
        List<String> divisions = employees.stream()
                .map(CsvEmployee::getDivisionName)
                .distinct()
                .toList();

        assertFalse(divisions.isEmpty());
        assertTrue(divisions.size() >= 1);
    }

    @Test
    @DisplayName("Should throw exception for non-existent file")
    void readEmployees_shouldThrowExceptionForNonExistentFile() {
        // When & Then
        assertThrows(RuntimeException.class, () -> {
            reader.readData("non-existent.csv");
        });
    }
}