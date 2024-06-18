package ru.gb.family_tree.model.family_tree;

import java.io.IOException;

public interface Writable {
    public void saveFileByte(Tree familyTree) throws IOException;


}
