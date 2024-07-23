import java.io.IOException;
import java.io.Serializable;

// public interface Writer {
//     void writeToFile(FamilyTree tree, String filename) throws IOException;
//     FamilyTree readFromFile(String filename) throws IOException, ClassNotFoundException;
// }

public interface Writer {
    void writeToFile(Serializable serializable);
    Object readFromFile();
    void setPath(String path);
}