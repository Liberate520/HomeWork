package Comparator;

import java.util.Comparator;

import familyTree.Human;

public class CompareByAge implements Comparator <Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}