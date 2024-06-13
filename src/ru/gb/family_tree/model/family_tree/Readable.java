package ru.gb.family_tree.model.family_tree;

import java.io.IOException;

public interface Readable {
    public FamilyTree loadFileByte() throws IOException, ClassNotFoundException;
}
