package familytree.human;

import familytree.human.Human;
import java.util.Comparator;

public class HumanAgeComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return Integer.compare(h2.calculateAge(), h1.calculateAge());
    }
}
