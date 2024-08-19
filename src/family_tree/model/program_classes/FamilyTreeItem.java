package family_tree.model.program_classes;

import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyTreeItem<T> extends Serializable, Comparable<T> {
    LocalDate getBirthDate();
    String getDocument();
    String getName();
    String getNamesHeader();
}
