package OOP.SemDZ.homeWork.model.write;

import java.io.Serializable;

public interface Writables {
    boolean save(Serializable serializable);
    Object read ();
}
