package Tree;

import java.io.Serializable;
import java.util.*;

import Human.Comparator.HumanComparatorByChildren;
import Human.Comparator.HumanComparatorByID;
import Human.Comparator.HumanComparatorByName;
import Human.Comparator.HumanComparatorBySurname;
import Human.Human;
import Human.Iterator.HumanIterator;

public class FamilyTree implements Serializable, Iterable<Human> {
    private static int lastID = 0;
    private final int ID = lastID++;
    private final ArrayList<Human> familyTree = new ArrayList<>();

    public void addHuman(Human human) {
        if (!this.familyTree.contains(human) && human != null) {

            this.familyTree.add(human);
            addHuman(human.getSpouse());
            addHuman(human.getMather());
            addHuman(human.getFather());

            for (Human kid: human.getChildren()) addHuman(kid);
        }
    }

    public void updateTree(){
        ArrayList<Human> copyFamilyTree = new ArrayList<>(this.familyTree);

        for (Human human: copyFamilyTree){

            addHuman(human.getFather());
            addHuman(human.getMather());
            addHuman(human.getSpouse());

            for (Human kid: human.getChildren()) addHuman(kid);
        }
    }

    public void removeHuman(int ID){
        this.familyTree.remove(ID);
    }

    public Human getHuman(int ID){
        for(Human human: this.familyTree){
            if (human.getID() == ID){
                return human;
            }
        }
        return null;
    }

    public int getID() {
        return ID;
    }

    public void sortBySurname(){
        this.familyTree.sort(new HumanComparatorBySurname());
    }

    public void sortByID(){
        this.familyTree.sort(new HumanComparatorByID());
    }

    public void sortByChildren(){
        this.familyTree.sort(new HumanComparatorByChildren());
    }

    public void sortByName(){
        this.familyTree.sort(new HumanComparatorByName());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(this.familyTree);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        for (Human human: this.familyTree){
            info.append(human);
        }

        return info.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() == obj.getClass()) return false;

        return this.ID == ((FamilyTree) obj).getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ID);
    }
}
