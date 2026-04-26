package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Division {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private final int id;

    @Getter
    @Setter
    private String name;

    public Division(String name) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
    }

    public int getId() { return id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return id == division.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() { return "Division{id=" + id + ", name='" + name + "'}"; }
}