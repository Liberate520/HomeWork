import java.io.*;

public interface FileHandler extends Writer {
    void writeToFile(String filename, Object obj) throws IOException;
    Object readFromFile(String filename) throws IOException, ClassNotFoundException;
}
