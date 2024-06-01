import java.io.IOException;
import java.util.List;

public interface Writable {
     void writeToFile(String filename, List<Human> people) throws IOException;
    List<Human> readFromFile(String filename) throws IOException, ClassNotFoundException;
}
