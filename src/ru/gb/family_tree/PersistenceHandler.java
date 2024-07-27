package ru.gb.family_tree;

public interface PersistenceHandler {

    FamilyTree readObject();
    void writeObject(FamilyTree obj);

}
