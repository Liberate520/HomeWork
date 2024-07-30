package model;

import java.time.LocalDate;
import java.util.List;

public interface FamilyMember<T extends FamilyMember<T>> {
    String getName();
    Gender getGender();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<T> getChildren();
    List<T> getParents();
    void addChild(T child);
    void addParent(T parent);
}