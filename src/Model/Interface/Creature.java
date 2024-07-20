package Model.Interface;

import Formating.MyDate;
import Model.Creatures.Gender.Gender;
import Model.Creatures.Human;

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

    void setName(String name);

    void setSurname(String surname);

    void setGender(Gender gender);

    void setDateOfBirth(MyDate dateOfBirth);

    void setDataOfDeath(MyDate dataOfDeath);

    void setFather(T father);

    void setMather(T mather);

    void setSpouse(T spouse);

    void addChildren(T new_kid);

    void removeKid(T kid);

    @Override
    String toString();

    @Override
    boolean equals(Object obj);

    @Override
    int hashCode();
}
