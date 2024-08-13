package homeWork.Human.Comporators;

import homeWork.Tree.TreeItem;
import homeWork.Human.Human;
import java.util.Comparator;

public class ComparingByBirthday<T extends TreeItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}