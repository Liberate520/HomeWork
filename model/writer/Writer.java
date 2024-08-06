package model.writer;

import model.family_tree.FamilyTree;
import model.human.Human;

public interface Writer {

    public void write(FamilyTree<Human> obj, String fileName);

    public Object read(String fileName) throws ClassNotFoundException;

}