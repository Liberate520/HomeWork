package family_tree.family_tree;
import java.util.Comparator;

public class ComparatorHumanName<T extends TreeClass<T>> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
