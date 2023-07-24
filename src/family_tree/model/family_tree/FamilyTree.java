package family_tree.model.family_tree;

import family_tree.model.human.comparators.HumanComparatorByBirthDate;
import family_tree.model.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> humanList;

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void add(E human) {
        humanList.add(human);
        addToParents(human);
        addToChildren(human);
    }

    private void addToParents(E human) {
        if (human.getParents() != null) {
            for (E parent : human.getParents()) {
                parent.addChild(human);
            }
        }
    }

    private void addToChildren(E human) {
        if (human.getChildren() != null) {
            for (E child : human.getChildren()) {
                child.addParent(human);
            }
        }
    }

    public E getByName(String name) {
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов:\n");
        for (E human : humanList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return humanList.iterator();
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByBirthDate() {
        humanList.sort(new HumanComparatorByBirthDate<>());
    }

    public void clear() {
        humanList.clear();
    }
    public List<E> getHumanList() {
        return humanList;
    }
}
