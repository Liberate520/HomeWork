package storage;

import model.Person;
import java.io.IOException;
import java.util.List;

public interface DataLoader {
    List<Person> loadData() throws IOException;
}


