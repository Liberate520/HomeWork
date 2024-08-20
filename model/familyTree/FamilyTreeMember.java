package model.familyTree;

import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyTreeMember<E> extends Serializable{
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    void addParent(E parent);
}
