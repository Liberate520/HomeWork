package model.family_tree;

import model.human.*;
import model.human.comparators.HumanComparatorByAge;
import model.human.comparators.HumanComparatorByBirthDate;
import model.human.comparators.HumanComparatorByName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E>{
    private List<E> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public List<E> getHumans(){
        return familyTree;
    }
    public void add(E human) {
        this.familyTree.add(human);
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
    public boolean setDivorce(E human1, E human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }
    public E findByName(String name) {
        for (E human : familyTree) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public E findById(int id){
        for(E human : familyTree){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public boolean remove(E human) {
        if (human != null) {
            familyTree.remove(human);
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return getInfo();
    }
    private String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В вашем древе ").append(familyTree.size()).append(" объектов\n");
        for (int i = 0; i < familyTree.size(); i++) {
            sb.append(i + 1 + ". " + familyTree.get(i) + "\n");
        }
        return sb.toString();
    }
    public void sortByName(){
        Collections.sort(familyTree, new HumanComparatorByName<>());
    }
    public void sortByAge(){
        Collections.sort(familyTree, new HumanComparatorByAge<>());
    }
    public void sortByBirthDate(){
        Collections.sort(familyTree, new HumanComparatorByBirthDate<>());
    }
    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(this);
    }
}
