package model.writable;

import java.io.Serializable;

public interface Writable<T> {
    void save(Serializable serializable);
}
