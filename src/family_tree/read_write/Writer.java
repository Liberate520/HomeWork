package family_tree.read_write;

import family_tree.family_tree.FamilyTree;

import java.io.IOException;

public interface Writer {
    void save(Serializable serializable);
    Object read();
    void setPath(String path);
}
