package family_tree.model.family_tree;

import java.time.LocalDate;

public interface ItemFamilyTree {
    String getName();

    LocalDate getDob();

    void setId(int i);
}