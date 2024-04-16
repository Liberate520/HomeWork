package family_tree.FamilyTree;

import family_tree.Human.Human;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeElements<E> {
    String getName();
    LocalDate getDob();
    List<E> getChildren();





}
