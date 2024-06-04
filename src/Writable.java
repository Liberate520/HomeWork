import java.io.IOException;

public interface Writable {
    void writeObjectToFile(Object obj) throws IOException;
    Object recoverObjectFromFile() throws IOException, ClassNotFoundException;
    void serializeObjectToByteArray(Object obj) throws IOException, ClassNotFoundException;
    Object recoverObjectFromByteArray(byte[] byteArray) throws IOException, ClassNotFoundException;
}
