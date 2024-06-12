package ru.gb.FamilyTree;

import java.io.Serializable;
//import java.io.IOException;

public interface Writable {
//    public void saveFileByte(FamilyTree familyTree) throws IOException;
//    public  FamilyTree loadFileByte() throws IOException, ClassNotFoundException;
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
