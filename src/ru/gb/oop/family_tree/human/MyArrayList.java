package ru.gb.oop.family_tree.human;

import java.util.ArrayList;
import java.util.Map;

public class MyArrayList extends ArrayList<Map.Entry<Human, Integer>> {
    public MyArrayList() {
        super();
    }
    public boolean contains(Human h) {
        for (Map.Entry<Human, Integer> entry : this) {
            if (entry.getKey().equals(h)) {
                return true;
            }
        }
        return false;
    }
}
