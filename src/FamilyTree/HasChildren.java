package FamilyTree;

import java.util.List;
import java.time.LocalDate;

public interface HasChildren<T> {
    List<T> getChildren();
    String getName();
    LocalDate getBirthDate();
}
