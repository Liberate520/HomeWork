package storage;

import model.Person;
import java.io.IOException;
import java.util.List;

public interface DataSaver {
    void saveData(List<Person> data) throws IOException;
}

