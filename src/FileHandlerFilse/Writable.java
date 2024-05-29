package FileHandlerFilse;

import PersonsTree.FamilyTree;

public interface Writable {
    void save(Object familyTree, String filePath);
    Object load(String Path);
}
