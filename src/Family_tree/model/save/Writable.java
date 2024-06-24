package Family_tree.model.save;

import ru.gb.Family_tree.model.family_tree.Family_tree;

public interface Writable {
    boolean save(Family_tree serializable, String filePath);
    Object read(String filePath);
}
