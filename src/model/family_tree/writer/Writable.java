package model.family_tree.writer;

import model.family_tree.instances.Human;
import model.family_tree.tree.FamilyTree;
import model.family_tree.tree.TreeItem;

import java.io.IOException;

public interface Writable<T extends TreeItem<T>> {
    public void writeToFamilyTree(FamilyTree<T> obj) throws IOException;
    public FamilyTree<T> readFromFamilyTree() throws IOException, ClassNotFoundException;
}
