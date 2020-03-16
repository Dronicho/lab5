package models;

import persistance.CsvSerilizable;

public class Location implements CsvSerilizable {
    private Integer x;
    private long y;
    private String name;

    public Location(Integer x, long y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
}
