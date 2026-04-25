package org.example.dto.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CsvEmployee {
    @CsvBindByName(column="id")
    private int id;

    @CsvBindByName(column="name")
    private String name;

    @CsvBindByName(column="BirthDate")
    @CsvDate("dd.MM.yyyy")
    private LocalDate birthDate;

    @CsvBindByName(column="gender")
    private String gender;

    @CsvBindByName(column = "Salary")
    private double salary;

    @CsvBindByName(column = "Division")
    private String divisionName;
}
