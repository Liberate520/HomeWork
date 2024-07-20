package Model.Interface;

import Model.Creatures.Gender.Gender;

import java.util.ArrayList;
import java.util.Iterator;

public interface FamilyTreeInterface<T extends Creature<T>>{

    void addCreature(T creature);

    void addCreature(String name, String surname, Gender gender);

    void updateTree();

    void removeCreature(int ID);

    T getCreature(int ID);

    ArrayList<T> getCreature(String name, String surname);

    int getID();

    void sortBySurname();

    void sortByChildren();

    void sortByName();

    void sortByID();

    int size();

    Iterator<T> iterator();

    @Override
    String toString();

    @Override
    boolean equals(Object obj);

    @Override
    int hashCode();
}
