package family__tree.model.family_tree_service;

import java.time.LocalDate;
import java.util.List;

public interface ItemFamilyTree<E> {
    String getName();
    LocalDate getBirth();
    List<E> getChildren();
    void addChild(E child);
    E getFather();
    E getMother();
    void setFather(E father);
    void setMother(E mother);
    int getAge();
    @Override
    String toString();
}
