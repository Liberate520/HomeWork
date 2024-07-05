package Human.Comparator;

import Human.Human;

import java.util.Comparator;

public class HumanComparatorByID implements Comparator<Human> {

    @Override
    public int compare(Human human_1, Human human_2) {
        return human_1.getID() - human_2.getID();
    }
}
