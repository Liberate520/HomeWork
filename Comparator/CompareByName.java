package Comparator;

import java.util.Comparator;

import familyTree.Human;

public class CompareByName implements Comparator <Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
