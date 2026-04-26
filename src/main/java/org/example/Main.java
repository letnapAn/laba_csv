package org.example;

import org.example.dto.EmployeeMapper;
import org.example.dto.csv.CsvEmployeeReader;
import org.example.entity.Employee;

import java.util.List;

/**
 * Точка входа в приложение и демонстрация работы pipeline CSV → DTO → Entity.
 * <p>
 * Инициализирует зависимости, запускает фасадный сервис и выводит
 * результат преобразования в консоль. Предназначен для локального запуска
 * и быстрой проверки контракта системы.
 *
 * @see FacadeService
 * @see CsvEmployeeReader
 * @see EmployeeMapper
 */
@SuppressWarnings("javadoc")
public class Main {

    /**
     * Запускает процесс чтения и маппинга сотрудников из CSV-файла.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        String resourcePath = "foreign_names.csv";

        CsvEmployeeReader reader = new CsvEmployeeReader();
        EmployeeMapper mapper = new EmployeeMapper();
        FacadeService service = new FacadeService(reader, mapper);

        List<Employee> employees = service.loadEmployees(resourcePath);

        employees.forEach(System.out::println);
    }
}