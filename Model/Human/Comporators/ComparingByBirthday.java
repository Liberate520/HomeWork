package homeWork.Model.Human.Comporators;

import homeWork.Model.Human.Human;
import homeWork.Model.Tree.TreeItem;

import java.util.Comparator;

public class ComparingByBirthday<T extends TreeItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}