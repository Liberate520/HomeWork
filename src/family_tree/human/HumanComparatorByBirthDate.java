package family_tree.human;

import java.util.Comparator;


// public class HumanComparatorByBirthDate<T extends TreeNode<E>> implements Comparator<T> {
//     @Override
//     public int compare(T h1, T h2) {
//         return h1.getDateOfBirth().compareTo(h2.getDateOfBirth());
//     }
// }


public class HumanComparatorByBirthDate<T> implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getDateOfBirth().compareTo(h2.getDateOfBirth());
    }
}
