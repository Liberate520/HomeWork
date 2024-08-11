package familyTree.model.familyTree;

import familyTree.model.human.HumanComporatorByAge;
import familyTree.model.human.HumanComporatorByID;
import familyTree.model.human.HumanComporatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> familyTree = new ArrayList<>();

    public boolean addHuman(E human) {
        if (human == null) {
            return false;
        }
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            addToParent(human);
            addToChildren(human);
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список:\n");
        for (E human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();

    }

    public void addToParent(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    public void addToChildren(E human) {
        if (human.getChildren() != null) {
            for (E child : human.getChildren()) {
                child.addParent(human);
            }
        }
    }

    public E getHuman(long id) {
        if (familyTree != null) {
            for (E human : familyTree) {
                if (human.getID() == id) {
                    return human;
                }
            }
        }
        return null;
    }

    public void sortByName() {
        Collections.sort(familyTree, new HumanComporatorByName<>());
    }

    public long findMaxID() {
        long maxID = 0;
        for (E e : familyTree) {
            if (maxID < e.getID()) {
                maxID = e.getID();
            }
        }
        return maxID;
    }

    public void sortByAge() {
        Collections.sort(familyTree, new HumanComporatorByAge<>());
    }

    public void sortByID() {
        Collections.sort(familyTree, new HumanComporatorByID<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyTree);
    }
}


