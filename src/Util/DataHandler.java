package Util;

import Model.FamilyTree;

public interface DataHandler {
    void saveFamilyTree(FamilyTree familyTree, String filename);
    FamilyTree loadFamilyTree(String filename);
}
