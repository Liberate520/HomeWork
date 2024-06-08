package FamilyTree.model.familyTree;

import FamilyTree.model.human.Gender;
import FamilyTree.model.human.Human;

import java.time.LocalDate;
import java.util.List;

public interface ElementFamilyTree <E> extends Comparable<E>{

    void setChildren(List<E> children);
    void addChild(E child);
    void addParents(E parent);
    LocalDate getBirthDate();
    long getId();
    void setId(long id);
    String getName();
    Gender getGender();
    Human getSpouse();
    String getSpouseInfo();
    List<E> getParents();
    List<E> getChildren();
    String getMotherInfo();
    String getFatherInfo();
    StringBuilder getChildrenInfo();
    int getAge();
    void setSpouse(E human2);

}
