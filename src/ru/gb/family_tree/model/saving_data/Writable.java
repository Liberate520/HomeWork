package ru.gb.family_tree.model.saving_data;

import java.io.Serializable;

public interface Writable {
    // Здесь обозначить методы сохранения и загрузки
    Object read_object(String target);

    void write_object(Serializable obj, String target);
}
