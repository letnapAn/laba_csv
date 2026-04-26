package org.example;

import org.example.dto.csv.CsvEmployee;
import org.example.entity.Employee;
import org.example.dto.EmployeeMapper;
import org.example.dto.csv.CsvEmployeeReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("FacadeService Tests")
class FacadeServiceTest {

    @Mock
    private CsvEmployeeReader reader;

    @Mock
    private EmployeeMapper mapper;

    private FacadeService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new FacadeService(reader, mapper);
    }

    @Test
    @DisplayName("Should convert CSV to entities")
    void shouldLoadEmployees() {
        CsvEmployee dto = new CsvEmployee(1, "John",
                LocalDate.of(1990, 1, 1), "M", 5000.0, "IT");
        Employee entity = new Employee(1, "John", "M",
                LocalDate.of(1990, 1, 1), null, 5000.0);

        when(reader.readData("test.csv")).thenReturn(List.of(dto));
        when(mapper.toEntity(dto)).thenReturn(entity);

        List<Employee> result = service.loadEmployees("test.csv");

        assertEquals(1, result.size());
        assertEquals("John", result.getFirst().getName());
        verify(reader).readData("test.csv");
        verify(mapper).toEntity(dto);
    }

    @Test
    @DisplayName("Should return empty list for empty CSV")
    void shouldHandleEmptyCsv() {
        when(reader.readData("empty.csv")).thenReturn(List.of());

        List<Employee> result = service.loadEmployees("empty.csv");

        assertTrue(result.isEmpty());
        verify(mapper, never()).toEntity(any());
    }
}