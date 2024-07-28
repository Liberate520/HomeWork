package Family_tree.human;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {
    public int compare(Human human1, Human human2){
        return human1.getAge() - human2.getAge();
    }

}
