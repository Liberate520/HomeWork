package Homework2_OOP;

import java.io.Serializable;

public interface Writer {
    public boolean save(Serializable serializable);
    public Object read(); 
}
