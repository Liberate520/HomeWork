package lv.homeWork.model.interfaces;


import java.io.Serializable;

public interface Writable {

    boolean save(Serializable serializable, String pathToFile);
    Object read(String pathToFile);
}
