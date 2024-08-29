package model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyTreeItem extends Serializable, Comparable<FamilyTreeItem> {
    String getName();

    LocalDate getBirthDate();

    int getAge();

    int getId();

    // --Commented out by Inspection (28.08.2024 8:54):void setId(int id);

}
