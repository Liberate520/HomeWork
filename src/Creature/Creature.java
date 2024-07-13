package Creature;

import Formating.MyDate;
import Gender.Gender;

import java.util.ArrayList;

public interface Creature<T> {
    String getName();

    String getSurname();

    ArrayList<T> getChildren();

    MyDate getDateOfBirth();

    MyDate getDataOfDeath();

    T getFather();

    T getMather();

    int getID();

    Gender getGender();

    T getSpouse();

    void setDateOfBirth(MyDate dateOfBirth);

    void setDataOfDeath(MyDate dataOfDeath);

    void setFather(T father);

    void setMather(T mather);

    void setSpouse(T spouse);

    void addChildren(T new_kid);

    @Override
    String toString();

    @Override
    boolean equals(Object obj);

    @Override
    int hashCode();
}
