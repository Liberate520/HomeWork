package Model;

import java.util.Comparator;

public class HumanComporatorByBirthDate implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getBirthDate().compareTo(h2.getBirthDate());
    }

}
