package lv.homeWork.model;


import java.io.Serializable;

public interface Writable {

    boolean save(Serializable serializable, String pathToFile);
    Object read(String pathToFile);
}
