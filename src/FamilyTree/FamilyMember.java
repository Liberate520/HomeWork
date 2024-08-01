package src.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyMember <E> extends Serializable {
    String getName();
    LocalDate getBirthDate();
    List<E> getChildren();
}
