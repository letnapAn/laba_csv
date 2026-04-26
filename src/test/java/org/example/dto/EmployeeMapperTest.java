package org.example.dto;

import org.example.dto.csv.CsvEmployee;
import org.example.entity.Division;
import org.example.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("EmployeeMapper Tests")
class EmployeeMapperTest {

    private EmployeeMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new EmployeeMapper();
    }

    @Test
    @DisplayName("Should convert DTO to Entity with correct field mapping")
    void toEntity_shouldMapAllFieldsCorrectly() {
        // Given
        CsvEmployee dto = new CsvEmployee(
                28281,
                "Aahan",
                LocalDate.of(1990, 5, 15),
                "Male",
                4800.0,
                "IT"
        );

        // When
        Employee employee = mapper.toEntity(dto);

        // Then
        assertEquals(28281, employee.getId());
        assertEquals("Aahan", employee.getName());
        assertEquals("Male", employee.getGender());
        assertEquals(LocalDate.of(1990, 5, 15), employee.getBirthDate());
        assertEquals(4800.0, employee.getSalary());
        assertNotNull(employee.getDivision());
        assertEquals("IT", employee.getDivision().getName());
    }

    @Test
    @DisplayName("Should cache divisions and reuse same instance")
    void toEntity_shouldCacheDivisionsAndReuseInstances() {
        // Given
        CsvEmployee employee1Dto = new CsvEmployee(
                1, "John", LocalDate.of(1990, 1, 1), "Male", 5000.0, "HR"
        );
        CsvEmployee employee2Dto = new CsvEmployee(
                2, "Jane", LocalDate.of(1992, 3, 15), "Female", 6000.0, "HR"
        );
        CsvEmployee employee3Dto = new CsvEmployee(
                3, "Bob", LocalDate.of(1988, 7, 20), "Male", 5500.0, "IT"
        );

        // When
        Employee employee1 = mapper.toEntity(employee1Dto);
        Employee employee2 = mapper.toEntity(employee2Dto);
        Employee employee3 = mapper.toEntity(employee3Dto);

        // Then
        Division hr1 = employee1.getDivision();
        Division hr2 = employee2.getDivision();
        Division it1 = employee3.getDivision();

        // Same division name should return same instance
        assertSame(hr1, hr2, "Divisions with same name should be the same instance");
        assertNotSame(hr1, it1, "Divisions with different names should be different instances");

        // Verify IDs are the same for cached divisions
        assertEquals(hr1.getId(), hr2.getId());
    }

    @Test
    @DisplayName("Should generate unique IDs for different divisions")
    void toEntity_shouldGenerateUniqueIdsForDifferentDivisions() {
        // Given
        CsvEmployee dto1 = new CsvEmployee(1, "A", LocalDate.of(1990, 1, 1), "M", 1000.0, "Sales");
        CsvEmployee dto2 = new CsvEmployee(2, "B", LocalDate.of(1990, 1, 1), "M", 1000.0, "Marketing");
        CsvEmployee dto3 = new CsvEmployee(3, "C", LocalDate.of(1990, 1, 1), "M", 1000.0, "Sales");

        // When
        Employee emp1 = mapper.toEntity(dto1);
        Employee emp2 = mapper.toEntity(dto2);
        Employee emp3 = mapper.toEntity(dto3);

        // Then
        Division sales1 = emp1.getDivision();
        Division marketing = emp2.getDivision();
        Division sales2 = emp3.getDivision();

        assertNotEquals(sales1.getId(), marketing.getId());
        assertEquals(sales1.getId(), sales2.getId());
    }

    @Test
    @DisplayName("Should handle multiple employees from different divisions")
    void toEntity_shouldHandleMultipleDivisionsCorrectly() {
        // Given
        CsvEmployee[] dtos = {
                new CsvEmployee(1, "E1", LocalDate.of(1990, 1, 1), "M", 1000.0, "IT"),
                new CsvEmployee(2, "E2", LocalDate.of(1990, 1, 1), "M", 1000.0, "HR"),
                new CsvEmployee(3, "E3", LocalDate.of(1990, 1, 1), "M", 1000.0, "IT"),
                new CsvEmployee(4, "E4", LocalDate.of(1990, 1, 1), "M", 1000.0, "HR"),
                new CsvEmployee(5, "E5", LocalDate.of(1990, 1, 1), "M", 1000.0, "Finance")
        };

        // When
        Employee[] employees = new Employee[5];
        for (int i = 0; i < dtos.length; i++) {
            employees[i] = mapper.toEntity(dtos[i]);
        }

        // Then
        // IT department - same instances
        assertSame(employees[0].getDivision(), employees[2].getDivision());

        // HR department - same instances
        assertSame(employees[1].getDivision(), employees[3].getDivision());

        // Different departments - different instances
        assertNotSame(employees[0].getDivision(), employees[1].getDivision());
        assertNotSame(employees[0].getDivision(), employees[4].getDivision());
        assertNotSame(employees[1].getDivision(), employees[4].getDivision());
    }
}