package familytree.model;

import java.time.LocalDate;
import java.util.List;

public interface Identifiable {
    FullName getFullName();
    LocalDate getDateOfBirth();
    LocalDate getDateOfDeath();
    List<? extends Identifiable> getChildren();
    void addParent(Identifiable parent);
    void addChild(Identifiable child);
}
