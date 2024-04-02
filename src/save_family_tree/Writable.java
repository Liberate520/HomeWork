package src.save_family_tree;

import java.io.IOException;

public interface Writable {
    void saveTree(Writable tree) throws IOException;

    Writable loadTree() throws IOException, ClassNotFoundException;
}