package Model.family_tree;

import Model.family_tree.human.ComparatorByBrthDate;
import Model.family_tree.human.ComparatorByName;
import Model.family_tree.human.ComporatorById;
import Model.family_tree.human.Item;

import java.util.Collections;
import java.util.List;

public class SortTree<C extends Item<C>> {
    private List<C> humans;
    private FamilyTree familyTree;

    public SortTree(List<C> humans) {
        this.humans = familyTree.getHumans();
    }

    public void SortByName() {
        Collections.sort(humans, new ComparatorByName<>());
    }

    public void SortByBrthDate() {
        Collections.sort(humans, new ComparatorByBrthDate<>());
    }

    public void sortById() {
        Collections.sort(humans, new ComporatorById<>());
    }
}
