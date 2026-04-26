/**
 * Приложение для чтения CSV-файлов и преобразования данных в доменные сущности.
 * <p>
 * Архитектура разделена на слои:
 * <ul>
 *   <li>{@code dto.csv} — DTO и компоненты чтения</li>
 *   <li>{@code dto} — интерфейсы и мапперы</li>
 *   <li>{@code entity} — доменные модели</li>
 *   <li>{@code FacadeService} — оркестратор процесса</li>
 * </ul>
 *
 * Pipeline: CSV → CsvEmployee → Employee. Кэширование {@link org.example.entity.Division}
 *           гарантирует идентичность объектов при маппинге.
 * @since 1.0
 */
package org.example;