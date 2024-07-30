package Model.Creature;

import Model.Formating.MyDate;

import java.util.ArrayList;

public interface Entity {
    String getName();

    String getSurname();

    ArrayList<Entity> getChildren();

    MyDate getDateOfBirth();

    MyDate getDataOfDeath();

    Entity getFather();

    Entity getMather();

    int getID();

    Gender getGender();

    Entity getSpouse();

    void setName(String name);

    void setSurname(String surname);

    void setGender(Gender gender);

    void setDateOfBirth(MyDate dateOfBirth);

    void setDataOfDeath(MyDate dataOfDeath);

    void setFather(Entity father);

    void setMather(Entity mather);

    void setSpouse(Entity spouse);

    void addKid(Entity new_kid);

    void addChildren(ArrayList<Entity> children);

    void removeKid(Entity kid);

    @Override
    String toString();

    @Override
    boolean equals(Object obj);

    @Override
    int hashCode();
}
