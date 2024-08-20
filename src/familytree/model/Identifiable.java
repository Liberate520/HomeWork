package familytree.model;

import java.time.LocalDate;
import java.util.List;

public interface Identifiable<T extends Identifiable> {
    FullName getFullName();
    LocalDate getDateOfBirth();
    LocalDate getDateOfDeath();
    List<Person> getChildren();
    void addParent(T parent);
    void addChild(T child);
}
