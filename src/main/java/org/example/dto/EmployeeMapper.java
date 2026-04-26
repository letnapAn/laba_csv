package org.example.dto;

import org.example.dto.csv.CsvEmployee;
import org.example.entity.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Маппер для конвертации {@link CsvEmployee} DTO в доменную сущность {@link Employee}.
 * <p>
 * Обеспечивает кэширование сущностей {@link Division} по названию подразделения
 * для гарантии идентичности объектов при маппинге нескольких сотрудников из одного отдела.
 * <p><b>Примечание реализации:</b> Используется {@link ConcurrentHashMap} для потокобезопасного кэширования.
 *
 * @see CsvEmployee
 * @see Employee
 * @see Division
 */
public class EmployeeMapper {

    private final Map<String, Division> divisionCache;

    /** Создает новый экземпляр маппера с пустым кэшем подразделений. */
    public EmployeeMapper() {
        this.divisionCache = new ConcurrentHashMap<>();
    }

    /**
     * Конвертирует DTO сотрудника в доменную сущность.
     *
     * @param dto DTO-объект с данными из CSV
     * @return сущность {@link Employee} с валидными ссылками на {@link Division}
     * @throws NullPointerException если {@code dto} или {@code dto.getDivisionName()} равны null
     */
    public Employee toEntity(CsvEmployee dto) {
        Division division = divisionCache.computeIfAbsent(dto.getDivisionName(), Division::new);
        return new Employee(dto.getId(), dto.getName(), dto.getGender(), dto.getBirthDate(), division, dto.getSalary());
    }
}