package family_tree.family_tree;

import family_tree.human.Human;

import java.util.Comparator;

public class ComporatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }
}
