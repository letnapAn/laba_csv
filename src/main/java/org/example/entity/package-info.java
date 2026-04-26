/**
 * Доменные сущности предметной области.
 * <p>
 * Содержит бизнес-объекты:
 * <ul>
 *   <li>{@link org.example.entity.Employee} — сотрудник</li>
 *   <li>{@link org.example.entity.Division} — подразделение</li>
 * </ul>
 * <p>
 * Идентичность сущностей определяется бизнес-идентификатором {@code id}.
 * Методы {@code equals()} и {@code hashCode()} переопределены на основе ID,
 * остальные поля допускают изменение через сеттеры.
 *
 * Генерация ID в Division потокобезопасна.
 * @since 1.0
 */
package org.example.entity;