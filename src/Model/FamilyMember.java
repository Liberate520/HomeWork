package Model;

import java.time.LocalDate;
import java.util.List;

public interface FamilyMember {
    String getName();

    LocalDate getBirthDate();

    List<? extends FamilyMember> getParents();

    List<? extends FamilyMember> getChildren();

    void addParent(FamilyMember parent);

    void addChild(FamilyMember child);

    int getAgeAt(LocalDate date);
}
