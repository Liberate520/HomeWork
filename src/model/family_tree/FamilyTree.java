package model.family_tree;

import model.family_tree.comparators.FamilyTreeComparatorByAge;
import model.family_tree.comparators.FamilyTreeComparatorByBirthDate;
import model.family_tree.comparators.FamilyTreeComparatorById;
import model.family_tree.comparators.FamilyTreeComparatorByName;
import model.human.Gender;
import model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private int nodeId;
    private final List<E> humanList;

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
            human.setId(nodeId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    public boolean getHuman(String name, Gender gender, LocalDate birthDate) {
        Human human = new Human(name, gender, birthDate);
        return add((E) human);
    }   /* Не знаю, как в этом методе заменить Human на E... */

    public void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    public void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public boolean addChild(int parentId, int childId) {
        E parent = getById(parentId);
        E child = getById(childId);
        if (parent != null && child != null) {
            parent.addChild(child);
            child.addParent(parent);
            return true;
        }
        return false;
    }

    public boolean setWedding(int humanId1, int humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setWedding(human1, human2);
        }

        return false;
    }

    public boolean setWedding(E human1, E human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(int humanId1, int humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(E human1, E human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean setBirthDate(int id, LocalDate birthDate) {
        E human = getById(id);
        if (human != null) {
            human.setBirthDate(birthDate);
            return true;
        }
        return false;
    }

    public boolean setDeathDate(int id, LocalDate deathDate) {
        E human = getById(id);
        if (human != null) {
            human.setDeathDate(deathDate);
            return true;
        }
        return false;
    }

    public boolean remove(int humanId) {
        if (checkId(humanId)) {
            E e = getById(humanId);
            return humanList.remove(e);
        }
        return false;
    }

    private boolean checkId(int id) {
        return id < nodeId && id >= 0;
    }

    public E getById(int id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: ");
        sb.append("\n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }

        return sb.toString();
    }

    public String infoById(int id) {
        StringBuilder sb = new StringBuilder("\n\n");
        E human = getById(id);
        sb.append(human);
        return sb.toString();
    }

    public void sortByName() {
        humanList.sort(new FamilyTreeComparatorByName<>());
    }

    public void sortByAge() {
        humanList.sort(new FamilyTreeComparatorByAge<>());
    }

    public void sortById() {
        humanList.sort(new FamilyTreeComparatorById<>());
    }

    public void sortByBirthDate() {
        humanList.sort(new FamilyTreeComparatorByBirthDate<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }
}