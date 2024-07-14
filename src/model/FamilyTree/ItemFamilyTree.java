package FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import Humans.Gender;

public interface ItemFamilyTree<U> extends Serializable {
    void setID(int ID);
    int getID();
    String getName();
    Gender getGender();
    boolean addChild(U human);
    boolean addParent(U human);
    LocalDate getDateOfBorn();
    LocalDate getDateOfDeath();
    U getMother();
    U getFather();
    List<U> getChildren();


}
