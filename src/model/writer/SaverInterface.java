package model.writer;

import java.io.Serializable;

public interface SaverInterface {
    boolean save(Serializable serializable);
}
