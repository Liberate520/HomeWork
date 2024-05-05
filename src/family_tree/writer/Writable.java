package family_tree.writer;

import java.io.IOException;
import java.util.List;

public interface Writable {
    void saveToFile(String filename, List<family_tree.human.Human> humans) throws IOException;

    List<family_tree.human.Human> loadFromFile(String filename) throws IOException, ClassNotFoundException;
}
