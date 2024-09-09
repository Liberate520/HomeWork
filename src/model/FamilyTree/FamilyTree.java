package model.FamilyTree;


import model.human.Human;
import model.human.comparators.HumanComparatorByAge;
import model.human.comparators.HumanComparatorByName;
import model.human.TreeNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private long humansId;
    private List<E> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean add(E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
           human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            if (!parent.getChildren().contains(human)) {
                parent.addChild(human);
            }
        }
    }

    private void addToChildren(E human) {
        if (human.getChildren() != null) {

        for (E child : human.getChildren()) {
            if (!child.getParents().contains(human)) {
                child.addParent(human);}
            }
        }
    }


    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("tree:\n");
        sb.append(humanList.size()).append(" members\n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }


    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }



    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }


    public void addHuman(E human) {
        add(human);
    }
}







