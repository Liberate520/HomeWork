package familyTree;

import human.Human;

import java.util.Comparator;

public class HumanComparatorByBirthDate implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2){return h1.getBirthDate().compareTo(h2.getBirthDate());}
}