package model.writer;

import model.family_tree.FamilyTree;

import java.io.Serializable;

public interface Write {
    void saveTree(String path, Serializable tree);
    FamilyTree loadingTree(String filepath);
}
