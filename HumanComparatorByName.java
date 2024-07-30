package family_tree.human;

import family_tree.family_tree.TreeNode;


public class HumanComparatorByName implements <T extends TreeNode> Comparator<T> {

        @Override
        public int compare(T o1, T o2) {
            return o1.getName().compareTo(o2.getName());
        }
}
