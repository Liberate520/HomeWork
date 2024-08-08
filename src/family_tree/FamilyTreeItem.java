package family_tree;

import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyTreeItem extends Serializable, Comparable<FamilyTreeItem>{
    String getName();
    LocalDate getBirthDate();
    int getAge();
}
