package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Доменная сущность, представляющая подразделение (отдел) компании.
 * <p>
 * Идентичность сущности определяется исключительно идентификатором {@code id}.
 * Генерация ID выполняется автоматически и потокобезопасно.
 *
 * @see Employee
 */
public class Division {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    /**
     * Уникальный идентификатор подразделения.
     */
    private final int id;

    /**
     * Название подразделения.
     */
    @Getter
    @Setter
    private String name;

    /**
     * Создаёт новое подразделение с автоматически присвоенным ID.
     *
     * @param name название подразделения
     */
    public Division(String name) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
    }

    /**
     * Возвращает идентификатор подразделения.
     *
     * @return уникальный ID
     */
    public int getId() { return id; }

    /**
     * Сравнивает сущности на основе идентификатора.
     *
     * @param o объект для сравнения
     * @return true, если объекты ссылаются на одну запись или имеют одинаковый ID
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return id == division.id;
    }

    /**
     * Возвращает хэш-код, вычисленный на основе идентификатора.
     *
     * @return хэш-код сущности
     */
    @Override
    public int hashCode() { return Objects.hash(id); }

    /**
     * Возвращает строковое представление подразделения.
     *
     * @return строка с ID и названием
     */
    @Override
    public String toString() { return "Division{id=" + id + ", name='" + name + "'}"; }
}