package Homework2_OOP;

import java.io.Serializable;

public interface Writer {
    boolean save(Serializable serializable);
    Object read(); 
}
