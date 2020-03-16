package models;

import persistance.CsvSerilizable;

public class Coordinates implements CsvSerilizable {
    private float x;
    private Long y;

    public Coordinates(float x, Long y) {
        this.x = x;
        this.y = y;
    }
}
