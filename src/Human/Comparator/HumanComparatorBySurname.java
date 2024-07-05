package Human.Comparator;

import Human.Human;

import java.util.Comparator;

public class HumanComparatorBySurname implements Comparator<Human> {

    @Override
    public int compare(Human human_1, Human human_2) {
        return  human_1.getSurname().compareTo(human_2.getSurname());
    }
}
