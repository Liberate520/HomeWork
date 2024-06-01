import java.io.IOException;

public interface Writable {

    void writeObjectToFile(Object obj) throws IOException;
    Object recoverObjectFromFile() throws IOException, ClassNotFoundException;

    void serializeObjectToByteArray(Object obj) throws IOException;
    Object recoverObjectFromByteArray() throws IOException, ClassNotFoundException;
}
