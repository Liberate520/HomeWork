package family_tree.writer;

import family_tree.family.FamilyTree;

import java.io.IOException;

public interface Writer {
    void Save(FamilyTree ft, String way);
    FamilyTree Input(String way);
}
