package model.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import model.Humans.Gender;

public interface ItemFamilyTree<U> extends Serializable {
    void setID(int humID);
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
