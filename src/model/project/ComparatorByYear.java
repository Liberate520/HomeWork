package model.project;

import java.util.Comparator;

public class ComparatorByYear<T extends User> implements Comparator<T>{
    @Override
    public int compare(T hum1, T hum2) {
        return Integer.compare(hum1.getYearOfBirth(), hum2.getYearOfBirth());
    }
}