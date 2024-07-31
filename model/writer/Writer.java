package model.writer;

import model.family_tree.FamilyTree;

public interface Writer {

    @SuppressWarnings("rawtypes")
    public void write(FamilyTree obj, String fileName);

    public Object read(String fileName) throws ClassNotFoundException;

}