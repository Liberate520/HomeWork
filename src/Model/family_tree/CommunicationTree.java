package Model.family_tree;

import Model.family_tree.human.Item;


import java.util.ArrayList;
import java.util.List;

public class CommunicationTree<C extends Item<C>> {
    private List<C> humans;

    private FamilyTree familyTree;

    public CommunicationTree(List<C> humans) {

        this.humans = familyTree.getHumans();
    }

    public void addToParents(C human) {
        for (C parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    public void addToChildren(C human) {
        for (C child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<C> getSiblings(int id) {
        C human = (C) familyTree.getById(id);

        if (human == null) {
            return null;
        }
        List<C> siblings = new ArrayList<>();
        for (C parent : human.getParents()) {
            for (C child : human.getChildren()) {
                if (!child.equals(human)) {
                    siblings.add(child);
                }
            }
        }

        return siblings;
    }

    public boolean setWedding(C human1, C human2) {
        boolean result;
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean setFamily(int id1, int id2) {
        C human1 = (C) familyTree.getById(id1);
        C human2 = (C) familyTree.getById(id2);
        if (!human2.getParents().contains(human1)) {

            human1.addChild(human2);
            human2.addParent(human1);
            return true;
        } else {
            return false;
        }
    }
}
