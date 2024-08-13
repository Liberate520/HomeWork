package homeWork.Human.Comporators;

import homeWork.Tree.TreeItem;
import homeWork.Human.Human;
import java.util.Comparator;

public class ComparingByName<T extends TreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}