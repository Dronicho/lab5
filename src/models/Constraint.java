package models;

import java.util.ArrayList;
import java.util.List;

public @interface Constraint {
    boolean NotNull() default true;
    boolean NotEmpty() default true;
    int MaxValue() default Integer.MAX_VALUE;
    int minValue () default 0;
}