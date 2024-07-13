package Tree;

import java.io.Serializable;
import java.util.*;

import Creature.Creature;
import Iterator.CreatureIterator;
import Comparators.*;

public class FamilyTree<T extends Creature<T>> implements Serializable, Iterable<T> {
    private static int lastID = 0;
    private final int ID = lastID++;
    private final ArrayList<T> familyTree = new ArrayList<>();

    public void addCreature(T creature) {
        if (!this.familyTree.contains(creature) && creature != null) {

            this.familyTree.add(creature);
            addCreature(creature.getSpouse());
            addCreature(creature.getMather());
            addCreature(creature.getFather());

            for (T kid: creature.getChildren()) addCreature(kid);
        }
    }

    public void updateTree(){
        ArrayList<T> copyFamilyTree = new ArrayList<>(this.familyTree);

        for (T creature: copyFamilyTree){

            addCreature(creature.getFather());
            addCreature(creature.getMather());
            addCreature(creature.getSpouse());

            for (T kid: creature.getChildren()) addCreature(kid);
        }
    }

    public void removeCreature(int ID){
        this.familyTree.remove(ID);
    }

    public T getCreature(int ID){
        for(T creature: this.familyTree){
            if (creature.getID() == ID){
                return creature;
            }
        }
        return null;
    }

    public int getID() {
        return ID;
    }

    public void sortBySurname(){
        this.familyTree.sort(new ComparatorBySurname<T>());
    }

    public void sortByID(){
        this.familyTree.sort(new ComparatorByID<T>());
    }

    public void sortByChildren(){
        this.familyTree.sort(new ComparatorByChildren<T>());
    }

    public void sortByName(){
        this.familyTree.sort(new ComparatorByName<T>());
    }

    @Override
    public Iterator<T> iterator() {
        return new CreatureIterator<T>(this.familyTree);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        for (T creature: this.familyTree){
            info.append(creature);
        }

        return info.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() == obj.getClass()) return false;

        return this.ID == ((FamilyTree<?>) obj).getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ID);
    }
}
