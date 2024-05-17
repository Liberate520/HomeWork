package Family_Tree.Writer;

import Family_Tree.model.FamilyTree.FamilyTree;

import java.io.IOException;

public interface WriteTo {

    void save(FamilyTree familyTree) throws IOException;

    void read(FamilyTree familyTree) throws IOException, ClassNotFoundException;

}
