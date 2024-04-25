package Model.FamilyTree;

import Model.Human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface LeafFamilyTree<E> extends Serializable {
    String getFirstName();

    String getLastName();

    E getMother();
    E getFather();

    List<E> getChildren();

    LocalDate getDob();

    LocalDate getDod();
    long getId();
    void setId(long id);
    void setDod(LocalDate dod);
    E getSpouse();

    Long getAge();
    String toString();
    String getStatus();
    String getChildrenInfo();
    String getInfo();


    void setSpouse(E human);
}
