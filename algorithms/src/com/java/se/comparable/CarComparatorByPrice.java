package com.java.se.comparable;

import java.util.Comparator;

public class CarComparatorByPrice implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPrice() - o2.getPrice() < 0 ? -1 : 1;
    }
}
