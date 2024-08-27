package writer;

import java.io.IOException;

public interface Writer<T> {
    void write(T obj, String fileName) throws IOException;
    T read(String fileName) throws IOException, ClassNotFoundException;
}
