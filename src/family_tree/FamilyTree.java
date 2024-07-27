package family_tree;

import human.Human;
import human.HumanComparatorByAge;
import human.HumanComparatorByBirthDate;
import human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void add(Human human) {
        this.familyTree.add(human);
    }

    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpause() == null && human2.getSpause() == null) {
            human1.setSpause(human2);
            human2.setSpause(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(Human human1, Human human2) {
        if (human1.getSpause() != null && human2.getSpause() != null) {
            human1.setSpause(null);
            human2.setSpause(null);
            return true;
        } else {
            return false;
        }
    }

    public Human findByName(String name) {
        for (Human human : this.familyTree) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public boolean remove(Human human) {
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
        sb.append("В вашем древе " + this.familyTree.size() + " объектов\n");
        for (int i = 0; i < familyTree.size(); i++) {
            sb.append(i + 1 + ". " + familyTree.get(i) + "\n");
        }
        return sb.toString();
    }
    public void sortByName(){
        Collections.sort(familyTree);
    }
    public void sortByAge(){
        Collections.sort(familyTree, new HumanComparatorByAge());
    }
    public void sortByBirthDate(){
        Collections.sort(familyTree, new HumanComparatorByBirthDate());
    }
    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);
    }
}
