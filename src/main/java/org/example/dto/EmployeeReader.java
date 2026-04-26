package org.example.dto;

import org.example.dto.csv.CsvEmployee;

import java.util.List;

/**
 * Интерфейс для чтения данных сотрудников из внешнего источника.
 * <p>
 * Определяет контракт для компонентов, отвечающих за загрузку
 * сырых данных в формате {@link CsvEmployee}.
 *
 * @see CsvEmployee
 * @see org.example.dto.csv.CsvEmployeeReader
 */
public interface EmployeeReader {

    /**
     * Считывает список сотрудников из указанного источника.
     *
     * @param resourcePath путь к источнику данных (например, файл в classpath)
     * @return неизменяемый список {@link CsvEmployee}, гарантированно не-null
     * @throws RuntimeException если источник недоступен или данные невалидны
     */
    List<CsvEmployee> readData(String resourcePath);
}