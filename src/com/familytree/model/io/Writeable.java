
package com.familytree.model.io;

import com.familytree.model.family_tree.FamilyTree;

import java.io.IOException;

public interface Writeable {
    void writeToFile(FamilyTree familyTree) throws IOException;
    FamilyTree readFromFile() throws IOException, ClassNotFoundException;
}
