package models;

import persistance.CsvSerilizable;

import java.time.LocalDateTime;

public class Person implements CsvSerilizable {
    private String name;
    private LocalDateTime birthday;
    private Color hairColor;
    private Location location;

    public Person(String name, LocalDateTime birthday, Color hairColor, Location location) {
        this.name = name;
        this.birthday = birthday;
        this.hairColor = hairColor;
        this.location = location;
    }
}
