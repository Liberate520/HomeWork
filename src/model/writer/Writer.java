package model.writer;

import java.io.Serializable;

public interface Writer{
    void save(Serializable serializable);
    Object loading();
}
