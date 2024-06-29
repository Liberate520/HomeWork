package model.family_tree;

import model.human.Gender;
import model.human.SpouseStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    long getId();
    void setId(long id);
    String getName();
    void setName(String name);
    LocalDate getBirthDate();
    void setBirthDate(LocalDate birthDate);
    LocalDate getDeathDate();
    void setDeathDate(LocalDate deathDate);
    Gender getGender();
    void setGender(Gender gender);

    List<T> getChildren();
    boolean addChild (T child);
    String getChildrenInfo();
    T getMother();
    void setMother(T mother);
    String getMotherInfo();
    T getFather();
    void setFather(T father);
    String getFatherInfo();
    void addParent(T parent);
    HashMap<T, SpouseStatus> getSpouse();
    void addSpouse(T spouse, SpouseStatus status);
    String getSpousesInfo();
    int getAge();
    String getLifeStatus();
    String getAbout();

}
