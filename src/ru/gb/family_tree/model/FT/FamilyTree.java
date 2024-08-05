package ru.gb.family_tree.model.FT;

import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.Human.comparator.ComparatorByBirthDate;
import ru.gb.family_tree.model.Human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem<T>> implements Serializable, Iterable<T>, FamilyTreeInterface<T> {
    private static final long serialVersionUID = 1L;

    private List<T> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(T human){
        humanList.add(human);
        System.out.println("Human added: " + human.getName());
    }

    public List<T> getHumanList() {
        return humanList;
    }

    public T findHumanById(long id) {
        for (T human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public void setParentsById(long childId, long motherId, long fatherId) {
        T child = findHumanById(childId);
        T mother = findHumanById(motherId);
        T father = findHumanById(fatherId);

        if (child != null) {
            child.setParents(mother, father);
            if (mother != null) {
                mother.addChild(child);
            }
            if (father != null) {
                father.addChild(child);
            }
        }
    }

    public void addChildById(long parentId, long childId) {
        T parent = findHumanById(parentId);
        T child = findHumanById(childId);

        if (parent != null && child != null) {
            parent.addChild(child);
            if (parent.getGender().equals(Gender.Female)) {
                child.setMother(parent);
            } else if (parent.getGender().equals(Gender.Male)){
                child.setFather(parent);
            } else {
                System.out.println("Родитель или ребенок не найдены.");
            }
        } else {
            System.out.println("Родитель или ребенок не найдены.");
        }

    }

    public boolean removeHumanById(long id) {
        T human = findHumanById(id);
        if (human != null) {
            T mother = human.getMother();
            T father = human.getFather();
            if (mother != null) {
                mother.getChildren().remove(human);
            }
            if (father != null) {
                father.getChildren().remove(human);
            }

            for (T child : human.getChildren()) {
                if (child.getMother() == human) {
                    child.setMother(null);
                }
                if (child.getFather() == human) {
                    child.setFather(null);
                }
            }
            humanList.remove(human);
            return true;
        }
        return false;

    }

    public T findHumanByName(String nameHuman){
        for (T human : humanList){
            if(human.getName().equalsIgnoreCase(nameHuman)){
                return human;
            }
        }
        return null;
    }

    public void sortByName(){
        Collections.sort(humanList);
    }

    public void sortByBirthDate(){
        humanList.sort(new ComparatorByBirthDate());
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator(humanList);
    }

    @Override
    public String toString() {
        return "Древо семьи{" +
                "Список членов семьи: " + humanList +
                '}';
    }

}
