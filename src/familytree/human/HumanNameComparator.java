package familytree.human;

import familytree.human.Human;
import java.util.Comparator;

public class HumanNameComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
