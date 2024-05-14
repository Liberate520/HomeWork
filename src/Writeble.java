import java.io.*;

interface Serializable {
    void serialize(String filename, Object obj) throws IOException;
    Object deserialize(String filename) throws IOException, ClassNotFoundException;
}
