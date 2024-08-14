package family_tree.help_classes;

import family_tree.program_classes.Human;

import java.time.LocalDate;

public interface FamilyTreeItem<T> extends Comparable<T>{
    LocalDate getBirthDate();
    String getDocument();
    String getName();
}
