package ru.gb.familytree.saveload;

public interface Writable {
    boolean save(Serializable serializable, String file);
    Object read(String file);
}
