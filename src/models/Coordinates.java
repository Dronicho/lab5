package models;

import persistance.CsvSerilizable;
import rules.NotNull;

public class Coordinates implements CsvSerilizable {
    private float x;
    private Long y;

    public Coordinates(float x, Long y) {
        this.x = x;
        this.y = y;
    }
}
