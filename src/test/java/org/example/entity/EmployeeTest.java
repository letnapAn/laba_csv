package org.example.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Employee Tests")
class EmployeeTest {

    @Test
    @DisplayName("Should create and access fields")
    void shouldCreateEmployee() {
        Division div = new Division("IT");
        Employee emp = new Employee(1, "John", "Male",
                LocalDate.of(1990, 1, 1), div, 5000.0);

        assertEquals(1, emp.getId());
        assertEquals("John", emp.getName());
        assertEquals(5000.0, emp.getSalary());
    }

    @Test
    @DisplayName("Should equal by ID only")
    void shouldEqualById() {
        Division div = new Division("IT");
        Employee emp1 = new Employee(1, "John", "M",
                LocalDate.of(1990, 1, 1), div, 5000.0);
        Employee emp2 = new Employee(1, "Jane", "F",
                LocalDate.of(2000, 1, 1), div, 3000.0);

        assertEquals(emp1, emp2); // одинаковый ID
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }
}
