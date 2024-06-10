package ru.gb.Family_tree;

public interface Writable {
    boolean save(Family_tree serializable, String filePath);
    Object read(String filePath);
}
