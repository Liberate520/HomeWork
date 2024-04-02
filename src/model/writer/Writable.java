package model.writer;

import java.io.IOException;
import model.tree.FamilyTree;
public interface Writable {

    FamilyTree load() throws IOException, ClassNotFoundException;
    boolean save(FamilyTree familyTree) throws IOException;
}
