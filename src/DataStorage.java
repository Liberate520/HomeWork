import java.io.IOException;
import java.util.List;

public interface DataStorage {
    void saveToFile(String filename, List<Person> people) throws IOException;
    List<Person> loadFromFile(String filename) throws IOException;
}
