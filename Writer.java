package homeWork;

import java.io.IOException;

public interface Writer {
    <T> void writeToFile(T object, String fileName) throws IOException;
    <T> T readFromFile(String fileName) throws IOException, ClassNotFoundException;
}
