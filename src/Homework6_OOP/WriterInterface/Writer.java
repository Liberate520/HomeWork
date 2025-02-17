package Homework6_OOP.WriterInterface;

import java.io.Serializable;

public interface Writer {
    boolean save(Serializable serializable, String filename);
    Object read(String filename);
}
