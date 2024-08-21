package homeWork.Model.Human.Comporators;

import homeWork.Model.Human.Human;
import homeWork.Model.Tree.TreeItem;

import java.util.Comparator;

public class ComparingByName<Human extends TreeItem> implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}