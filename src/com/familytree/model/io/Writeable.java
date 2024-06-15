
package com.familytree.model.io;

import com.familytree.model.family_tree.FamilyTree;
import com.familytree.model.human.Human;

import java.io.IOException;
import java.io.Serializable;

public interface Writeable {
    <T extends Serializable> void writeToFile(FamilyTree<Human> familyTree, String filePath) throws IOException;

    <T extends Serializable> FamilyTree<Human> readFromFile(String filePath) throws IOException, ClassNotFoundException;
}
