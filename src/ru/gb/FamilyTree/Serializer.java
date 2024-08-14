package ru.gb.FamilyTree;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public interface Serializer<FamilyTree extends Serializable> {
    void serializer(FamilyTree familyTree) throws IOException;

    FamilyTree deserialize() throws IOException, ClassNotFoundException;
}
