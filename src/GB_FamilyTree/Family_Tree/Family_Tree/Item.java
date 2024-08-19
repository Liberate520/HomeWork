package GB_FamilyTree.Family_Tree.Family_Tree;

import GB_FamilyTree.Family_Tree.Human.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface Item<T> extends Serializable  {
    long getId();
    String getName();
    Gender getGender();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    T getFather();
    T getMother();
    T getSpouse();
    List<T> getChildren();
    List<T> getParents();
    int getAge();
    void setId(long id);
    void setName(String name);
    void setGender(Gender gender);
    void setBirthDate(LocalDate birthDate);
    void setDeathDate(LocalDate deathDate);
    void setFather(T father);
    void setMother(T mother);
    void setSpouse(T spouse);
    void setChildren(List<T> children);
    boolean addChild(T child);
    boolean addParent(T parent);
}
