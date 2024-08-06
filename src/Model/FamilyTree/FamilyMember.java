package src.Model.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyMember <E> extends Serializable {
    void setID(long id);
    long getId();
    E getFather();
    E getMother();
    void addChildren(E child, E parent);
    void addParent(E child, E parent);
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<E> getChildren();
}
