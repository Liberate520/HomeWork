package Writer;

import FamilyTree.FamilyTree;

public interface Writer {
    void setPath(String path);
    void save(FamilyTree<?> tree);
    FamilyTree<?> read();
}

