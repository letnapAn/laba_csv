/**
 * DTO-классы и компоненты для чтения данных сотрудников из CSV-файлов.
 * <p>
 * Пакет содержит:
 * <ul>
 *   <li>{@link org.example.dto.csv.CsvEmployee} — DTO для маппинга колонок CSV</li>
 *   <li>{@link org.example.dto.csv.CsvEmployeeReader} — реализация чтения через OpenCSV</li>
 * </ul>
 * <p>
 * Все классы пакета предназначены для внутреннего использования в слое
 * конвертации данных и не являются публичным API приложения.
 * <p><b>Примечание:</b> Используется библиотека OpenCSV с аннотациями {@code @CsvBindByName}
 * и {@code @CsvDate} для декларативного биндинга.
 *
 * @since 1.0
 */
package org.example.dto.csv;