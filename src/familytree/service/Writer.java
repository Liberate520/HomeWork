package familytree.service;

import familytree.model.FamilyTree;
import familytree.model.TreeMember;

import java.io.IOException;

public interface Writer<T extends TreeMember> {
    void save(FamilyTree<T> familyTree, String fileName) throws IOException;
    FamilyTree<T> load(String fileName) throws IOException, ClassNotFoundException;
}