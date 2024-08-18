package Model;

import java.time.LocalDate;
import java.util.List;

public interface FamilyMember {
    String getName();

    LocalDate getBirthDate();

    List<? extends FamilyMember> getParents();

    List<? extends FamilyMember> getChildren();
}
