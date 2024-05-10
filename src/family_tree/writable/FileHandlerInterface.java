package family_tree.writable;



import family_tree.person.Person;

import java.io.Serializable;
import java.util.Map;

public interface FileHandlerInterface extends Serializable {
    void writeToFile(Map<Integer, Person> peopleMap, String filename);

    Map<Integer, Person> readFromFile(String filename);
}
