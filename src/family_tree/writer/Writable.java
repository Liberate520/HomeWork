package family_tree.writer;

import java.io.*;

public interface Writable {
    boolean save(Serializable serializable, String FilePath);
    Object read(String FilePath);
//    void write(FamilyTree familyTree);
//    FamilyTree load();
}
