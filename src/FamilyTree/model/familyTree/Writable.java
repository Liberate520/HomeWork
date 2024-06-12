package FamilyTree.model.familyTree;

import FamilyTree.model.element.ElementFamilyTree;

import java.io.*;

public interface Writable<E extends ElementFamilyTree<E>> {

    void save(FamilyTree<E> familyTree, String filePatch) throws IOException;
    FamilyTree<E> load(String filePatch) throws IOException, ClassNotFoundException;
}
