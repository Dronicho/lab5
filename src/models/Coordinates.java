package models;

import persistance.CsvSerilizable;

public class Coordinates implements CsvSerilizable {
    private double x;
    private Long y;

    public Coordinates(double x, Long y) {
        this.x = x;
        this.y = y;
    }
}
