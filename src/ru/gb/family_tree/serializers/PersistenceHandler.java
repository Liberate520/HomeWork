package ru.gb.family_tree.serializers;

import java.io.IOException;

public interface PersistenceHandler<T> {
    T readObject() throws IOException, ClassNotFoundException;
    void writeObject(T obj) throws IOException;
}
