package FamilyTree;

import Human.Human;

import java.time.LocalDate;
import java.util.List;

public interface ItemFamilyTree <E extends ItemFamilyTree<E>>{
    String getName();
    void setId(long id);
    long getId();

    List<E> getChildren();
    LocalDate getDateBrith();
    boolean addChild(E human);
    List<E> getParents();
    boolean addParent(E human);
}
