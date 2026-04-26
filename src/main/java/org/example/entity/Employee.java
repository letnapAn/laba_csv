package org.example.entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Доменная сущность, представляющая сотрудника компании.
 * <p>
 * Идентичность определяется полем {@code id}. Остальные атрибуты могут изменяться
 * через сеттеры. Ссылка на подразделение {@link Division} является обязательной частью контракта.
 *
 * @see Division
 */
public class Employee {
    /** Уникальный идентификатор сотрудника. */
    private final int id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private Division division;
    private double salary;

    /**
     * Создает сотрудника с полной инициализацией полей.
     *
     * @param id        уникальный идентификатор
     * @param name      ФИО сотрудника
     * @param gender    пол сотрудника
     * @param birthDate дата рождения
     * @param division  подразделение, к которому прикреплён сотрудник
     * @param salary    заработная плата
     */
    public Employee(int id, String name, String gender, LocalDate birthDate, Division division, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.division = division;
        this.salary = salary;
    }

    /**
     * Возвращает уникальный идентификатор сотрудника.
     * @return идентификатор сотрудника
     */
    public int getId() { return id; }

    /**
     * Возвращает ФИО сотрудника.
     * @return ФИО сотрудника
     */
    public String getName() { return name; }

    /**
     * Устанавливает новое ФИО сотрудника.
     * @param name ФИО сотрудника
     */
    public void setName(String name) { this.name = name; }

    /**
     * Возвращает пол сотрудника.
     * @return пол сотрудника
     */
    public String getGender() { return gender; }

    /**
     * Устанавливает новый пол сотрудника.
     * @param gender пол сотрудника
     */
    public void setGender(String gender) { this.gender = gender; }

    /**
     * Возвращает дату рождения.
     * @return дата рождения
     */
    public LocalDate getBirthDate() { return birthDate; }

    /**
     * Устанавливает новую дату рождения.
     * @param birthDate дата рождения
     */
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    /**
     * Возвращает подразделение сотрудника.
     * @return подразделение сотрудника
     */
    public Division getDivision() { return division; }

    /**
     * Устанавливает новое подразделение.
     * @param division подразделение сотрудника
     */
    public void setDivision(Division division) { this.division = division; }

    /**
     * Возвращает заработную плату.
     * @return заработная плата
     */
    public double getSalary() { return salary; }

    /**
     * Устанавливает новую заработную плату.
     * @param salary заработная плата
     */
    public void setSalary(double salary) { this.salary = salary; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', gender='" + gender + "', birthDate=" + birthDate + ", division=" + division + ", salary=" + salary + '}';
    }
}