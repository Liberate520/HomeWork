package Human.Comparator;

import Human.Human;

import java.util.Comparator;

public class HumanComparatorByChildren implements Comparator<Human> {
    @Override
    public int compare(Human human_1, Human human_2) {
        return human_2.getChildren().size() - human_1.getChildren().size();
    }
}
