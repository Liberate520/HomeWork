package family__tree.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface ItemFamilyTree {

    String getName();

    LocalDate getBirth();

    <E extends ItemFamilyTree> List<E> getChildren();
}

