package Model.FamilyTree;

import java.io.Serializable;
import java.util.*;
import java.util.function.Supplier;

import Model.Creatures.Gender.Gender;
import Model.Interface.Creature;
import Model.Creatures.Iterator.CreatureIterator;
import Model.FamilyTree.Comparators.*;
import Model.Interface.FamilyTreeInterface;

public class FamilyTree<T extends Creature<T>> implements Serializable, Iterable<T>, FamilyTreeInterface<T> {
    private static int lastID = 0;
    private final int ID = lastID++;
    private final ArrayList<T> familyTree = new ArrayList<>();
    private final Supplier<T> supplier;

    public FamilyTree(Supplier<T> supplier){
        this.supplier = supplier;
    }

    public void addCreature(T creature) {
        if (!this.familyTree.contains(creature) && creature != null) {

            this.familyTree.add(creature);
            addCreature(creature.getSpouse());
            addCreature(creature.getMather());
            addCreature(creature.getFather());

            for (T kid: creature.getChildren()) addCreature(kid);
        }
    }

    public void addCreature(String name, String surname, Gender gender){
        T creature = supplier.get();

        creature.setName(name);
        creature.setSurname(name);
        creature.setGender(gender);

        addCreature(creature);
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
        Creature<T> creature = getCreature(ID);

        if (creature != null){
            Creature mather = creature.getMather();
            Creature father = creature.getFather();
            Creature spouse = creature.getSpouse();
            ArrayList<T> children = new ArrayList<>(creature.getChildren());

            if (mather != null) mather.removeKid(creature);
            if (father != null) father.removeKid(creature);
            if (spouse != null) spouse.setSpouse(null);

            if (children != null){
                for (T kid: children){
                    if (kid.getFather().equals(creature)) kid.setFather(null);
                    else kid.setMather(null);
                }
            }
            this.familyTree.remove(creature);
        }
    }

    public T getCreature(int ID){
        for(T creature: this.familyTree){
            if (creature.getID() == ID){
                return creature;
            }
        }
        return null;
    }

    public ArrayList<T> getCreature(String name, String surname){
        ArrayList<T> creatures = new ArrayList<>();

        for (T creature: this.familyTree){
            if (creature.getName().equalsIgnoreCase(name) && creature.getSurname().equalsIgnoreCase(surname)){
                creatures.add(creature);
            }
        }

        return creatures;
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

    public int size(){
        return this.familyTree.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new CreatureIterator<T>(this.familyTree);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        if (!this.familyTree.isEmpty()){
            for (int index = 0; index != familyTree.size() - 1; index++){
                info.append(familyTree.get(index)).append("\n");
            }
            info.append(familyTree.getLast());
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
