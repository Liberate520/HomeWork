package ru.gb.family_tree.serializers;

import ru.gb.family_tree.FamilyTree;

public interface PersistenceHandler {

    FamilyTree readObject();
    void writeObject(FamilyTree obj);

}
