package familyTree.model.human;

import familyTree.model.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComporatorByID <T extends FamilyTreeItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Long.compare(o1.getID(), o2.getID());
    }
}
