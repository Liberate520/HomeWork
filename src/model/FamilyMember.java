package model;

import java.time.LocalDate;
import java.util.List;

public interface FamilyMember {

    String getName();
    Gender getGender();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<FamilyMember> getChildren();
    List<FamilyMember> getParents();

    void addParent(FamilyMember human);
}
