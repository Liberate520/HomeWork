package Homework4_OOP.WriterInterface;

import java.io.Serializable;

public interface Writer {
    boolean save(Serializable serializable, String filename);
    Object read(String filename);
}
