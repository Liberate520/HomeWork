package Model.family_tree;

import Model.family_tree.human.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface Item<T>extends Serializable {
    void setId(int id);
    String getName();
    void setBrthDate(LocalDate brthDate);
    LocalDate getBrthDate();
    void setDthDate(LocalDate dthDate);
    T getFather();
    T getMother();
    void setSpouse(T human);
    boolean addParent(T human);
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    int getId();
    Gender getSex();
    void setSex(Gender sex);
    void setName(String name);
    String getSpousInfo();
    String getFatherInfo();
    String getMotherInfo();
    String getChildrenInfo();
    boolean addChild(T child);




}

