package familyTree;

import java.time.LocalDate;

public interface FamilyTreeMember {
    String getName();
    Gender gender = null;
    LocalDate getBirthDate();
    LocalDate getDeathDate();
}
