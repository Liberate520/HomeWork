package ru.gb.Family_tree.save;

import ru.gb.Family_tree.family_tree.Family_tree;

public interface Writable {
    boolean save(Family_tree serializable, String filePath);
    Object read(String filePath);
}
