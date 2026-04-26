package org.example.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private final int id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private Division division;
    private double salary;

    public Employee(int id, String name, String gender, LocalDate birthDate, Division division, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.division = division;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public Division getDivision() { return division; }
    public void setDivision(Division division) { this.division = division; }
    public double getSalary() { return salary; }
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