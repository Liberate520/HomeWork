package ru.gb.family_tree.family_tree;

import java.io.IOException;

public interface Writable {
    public void saveFileByte(FamilyTree familyTree) throws IOException;

    public FamilyTree loadFileByte() throws IOException, ClassNotFoundException;
}
