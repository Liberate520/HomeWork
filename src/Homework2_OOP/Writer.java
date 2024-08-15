package Homework2_OOP;

import java.io.Serializable;

public interface Writer {
    boolean save(Serializable serializable, String filename);
    Object read(String filename);
}
