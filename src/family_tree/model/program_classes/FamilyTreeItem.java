package family_tree.model.program_classes;

import java.time.LocalDate;

public interface FamilyTreeItem<T> extends Comparable<T>{
    LocalDate getBirthDate();
    String getDocument();
    String getName();
    String getNamesHeader();
}
