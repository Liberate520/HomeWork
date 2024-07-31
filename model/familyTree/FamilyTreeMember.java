package model.familyTree;

import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyTreeMember<E> extends Serializable {
    String getName();
    Gender gender = null;
    LocalDate getBirthDate();
    LocalDate getDeathDate();
}
