package OOP.SemDZ.homeWork.write;

import java.io.Serializable;

public interface Writables {
    boolean save(Serializable serializable, String path);
    Object read (String path);
}
