package service;

import java.io.IOException;

public interface Writable {
    void save(Object obj, String path) throws IOException;
}
