    package familytree.model.human;

    import familytree.model.human.Human;
    import java.util.Comparator;
    import familytree.model.family_tree.TreeElement;

    public class HumanNameComparator<T extends TreeElement<T>> implements Comparator<T> {
        @Override
        public int compare(T h1, T h2) {
            return h1.getName().compareTo(h2.getName());
        }
    }