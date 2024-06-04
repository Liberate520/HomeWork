import java.io.IOException;

public interface Writable {
    void writeObjectToFile(Object obj, String filePath) throws IOException;
    Object recoverObjectFromFile(String filePath) throws IOException, ClassNotFoundException;
//    void serializeObjectToByteArray(Object obj) throws IOException, ClassNotFoundException;
//    Object recoverObjectFromByteArray(byte[] byteArray) throws IOException, ClassNotFoundException;
}
