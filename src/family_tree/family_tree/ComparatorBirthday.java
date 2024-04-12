package family_tree.family_tree;
import java.util.Comparator;

public class ComparatorBirthday<T extends TreeClass<T>> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return o1.getDob().compareTo(o2.getDob());
    }
    
}