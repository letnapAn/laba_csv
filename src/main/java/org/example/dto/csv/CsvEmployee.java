package org.example.dto.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


/** Создает экземпляр DTO со значениями по умолчанию. */
@NoArgsConstructor
@Data
@AllArgsConstructor
/**
 * DTO для маппинга данных сотрудника из CSV-файла.
 * <p>
 * Используется библиотекой OpenCSV для автоматического биндинга
 * колонок CSV к полям класса через аннотации.
 *
 * @see CsvEmployeeReader
 */
@SuppressWarnings("javadoc")
public class CsvEmployee {

    /**
     * Уникальный идентификатор сотрудника.
     */
    @CsvBindByName(column="id")
    private int id;

    /**
     * Полное имя сотрудника.
     */
    @CsvBindByName(column="name")
    private String name;

    /**
     * Дата рождения сотрудника.
     * <p>
     * Формат в CSV: dd.MM.yyyy
     */
    @CsvBindByName(column="BirthDate")
    @CsvDate("dd.MM.yyyy")
    private LocalDate birthDate;

    /**
     * Пол сотрудника.
     */
    @CsvBindByName(column="gender")
    private String gender;

    /**
     * Заработная плата сотрудника.
     */
    @CsvBindByName(column = "Salary")
    private double salary;

    /**
     * Название подразделения (отдела) сотрудника.
     * <p>
     * Используется для последующего маппинга на сущность {@link org.example.entity.Division}.
     */
    @CsvBindByName(column = "Division")
    private String divisionName;
}