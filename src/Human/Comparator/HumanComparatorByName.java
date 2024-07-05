package Human.Comparator;

import Human.Human;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human> {

    @Override
    public int compare(Human human_1, Human human_2) {
        return human_2.getName().compareTo(human_1.getName());
    }
}
