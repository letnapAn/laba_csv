package org.example;

import org.example.dto.csv.CsvEmployee;
import org.example.dto.EmployeeReader;
import org.example.dto.EmployeeMapper;

import org.example.entity.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Фасад для оркестрации процесса загрузки и трансформации данных сотрудников.
 * <p>
 * Инкапсулирует взаимодействие между слоем чтения ({@link EmployeeReader})
 * и слоем маппинга ({@link EmployeeMapper}), предоставляя единый контракт
 * для получения готовых доменных объектов.
 *
 * @see EmployeeReader
 * @see EmployeeMapper
 * @see Employee
 */
public class FacadeService {

    private final EmployeeReader reader;
    private final EmployeeMapper mapper;

    /**
     * Создаёт экземпляр сервиса с заданными зависимостями.
     *
     * @param reader реализация читателя CSV-данных
     * @param mapper маппер DTO в доменные сущности
     */
    public FacadeService(EmployeeReader reader, EmployeeMapper mapper) {
        this.reader = reader;
        this.mapper = mapper;
    }

    /**
     * Загружает и конвертирует список сотрудников из указанного источника.
     *
     * @param resourcePath путь к CSV-файлу в classpath
     * @return список доменных объектов {@link Employee}
     * @throws RuntimeException если чтение или маппинг завершатся ошибкой
     */
    public List<Employee> loadEmployees(String resourcePath) {
        List<CsvEmployee> dtos = reader.readData(resourcePath);
        return dtos.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }
}