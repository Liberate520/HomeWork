package Homework6_OOP.WriterInterface;

import java.io.Serializable;

public interface IDataHandler {
    boolean save(Serializable serializable, String filename);
    Object load(String filename);
}