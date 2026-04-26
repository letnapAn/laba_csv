package org.example.dto.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.example.dto.EmployeeReader;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация читателя данных сотрудников из CSV-файла.
 * <p>
 * Использует библиотеку OpenCSV для парсинга CSV с разделителем ';'
 * и автоматического маппинга на {@link CsvEmployee}.
 *
 * @see CsvEmployee
 * @see EmployeeReader
 */
@SuppressWarnings("javadoc")
public class CsvEmployeeReader implements EmployeeReader {

    /**
     * Считывает данные сотрудников из CSV-файла.
     *
     * @param resourcePath путь к CSV-файлу в classpath (resources)
     * @return список объектов {@link CsvEmployee} с данными из файла
     * @throws IllegalStateException если файл не найден в classpath
     * @throws RuntimeException    если произошла ошибка при парсинге CSV
     */
    @Override
    public List<CsvEmployee> readData(String resourcePath) {
        try (var inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IllegalStateException("Resource not found: " + resourcePath);
            }

            CsvToBean<CsvEmployee> csvToBean = new CsvToBeanBuilder<CsvEmployee>(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .withType(CsvEmployee.class)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return new ArrayList<>(csvToBean.parse());
        } catch (Exception e) {
            throw new RuntimeException("CSV reading failed", e);
        }
    }
}