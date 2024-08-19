package homeWork.Model.Human.Comporators;

import homeWork.Model.Human.Human;
import homeWork.Model.Tree.TreeItem;

import java.util.Comparator;

public class ComparingByName<T extends TreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}