package family_tree.model.FamilyTree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeElements<E> {
    String getName();
    LocalDate getDob();
    List<E> getChildren();





}
