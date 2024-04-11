package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.iterator.ComparatorByAge;
import ru.gb.family_tree.iterator.ComparatorByName;
import ru.gb.family_tree.iterator.FamilyTreeIterator;

import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import java.util.Iterator;


public class FamilyTree<E extends FamilyTreeElement<E>> implements Serializable, Iterable<E> {

    private long humanId;
    private List<E> humanList;


    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }


    public boolean addHuman(E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humanId++);

            addParentsRelations(human);
            addChildrenRelations(human);

            return true;
        }
        return false;
    }


    private void addParentsRelations(E human) {
        E mother = human.getMother();
        if (mother != null) {
            mother.addChild(human);
        }

        E father = human.getFather();
        if (father != null) {
            father.addChild(human);
        }
    }


    private void addChildrenRelations(E human) {
        if (human.getChildren().size() > 0) {
            for (E child : human.getChildren()) {
                if (human.getGender() == Gender.female) {
                    child.setMother(human);
                } else {
                    child.setFather(human);
                }
            }
        }
    }


    public E findById(long id) {
        for (E human: humanList) {
            if (human.getId() == id) {
                System.out.println(human);
                return human;
            }
        }
        return null;
    }


    public List<E> findByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human: humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                res.add(human);
            }
        }
        for (E human : res) {
            System.out.println(human);
        }
        return res;
    }


    public String getAboutFamily() {
        StringBuilder sb = new StringBuilder();
        sb.append("Humans in family: ");
        sb.append(humanList.size() + "\n\n------------\nThey are:\n\n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
            sb.append("-----------\n");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return getAboutFamily();
    }


    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }


    public void sortByAge() {
        humanList.sort(new ComparatorByAge<>());
    }


    public void sortByName() {
        humanList.sort(new ComparatorByName<>());
    }

}


//---------------------------------------------------------
