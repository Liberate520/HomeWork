package model.familiTree;

import model.human.comparators.HumanComparatorByAge;
import model.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E>{

    private long humanId;
    private List<E> humans;

    public FamilyTree() {
        this.humanId = 1;
        this.humans = humans == null ? new ArrayList<>() : humans;
    }


    public E getByName(String nameHuman) { //  поиск по имени
        for (E human : humans) {
            if (human.getName().equals(nameHuman)) {
                return human;
            }
        }
        return null;
    }

    public void sortByName() {
        humans.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humans.sort(new HumanComparatorByAge<>());
    }

    public E getById(long id) { //  поиск по id
        for (E human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }


    public boolean addHuman(E human) {
        if (human != null && !humans.contains(human)) {
            if (human.getId() == -1) {
                human.setId(humanId++);
            }
            return this.humans.add(human);
        }
        return false;
    }



    public List<E> findChildrenByParent(E parent, E excludeHuman) {
        List<E> children = new ArrayList<>();
        for (E human : humans) {
            if (human.isParent(parent) && !human.equals(excludeHuman)) {
                children.add(human);
            }
        }
        return children;
    }

    public List<E> findChildrenByParentId(long parentId) {
        return findChildrenByParent(getById((int) parentId), null);
    }

    public List<E> findSiblingsById(long humanId) {
        E child = getById((int) humanId);
        return findChildrenByParent(child.getMother() != null ? child.getMother() : child.getFather(), child);
    }




//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        System.out.println("Генеалогическое древо (размер = " + humans.size() + "):");
//
//        for (E human : humans) {
//            stringBuilder.append(human);
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString().replaceAll("^\\[|\\,|\\]$", "");
//    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FamilyTree that = (FamilyTree) obj;
        return humanId == that.humanId && Objects.equals(humans, that.humans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(humanId, humans);
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humans);
    }
}
