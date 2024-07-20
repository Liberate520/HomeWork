package FamilyTree;

import java.time.LocalDate;

public interface HasId {
    int getId();
    String getName();
    LocalDate getBirthDate();
    int getAge();
}
