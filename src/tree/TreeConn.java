package tree;

import human.Alive;
import human.Gender;
import human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeConn<T> extends Serializable {
    void setId(int id);
    int getId();
    List<T> getParents();
    List<T> getChildren();
    void addChildren(T human);
    void addParent(T human);
    String getName();
    void setName(String name);
    T getMother();
    T getFather();
    T getSpouse();
    void setSpouse(T human);
    LocalDate getBirthDay();
    void setBirthDay(LocalDate birthDay);
    LocalDate getDeathDay();
    void setDeathDay(LocalDate deathDay);
    Gender getGender();
    void setGender(Gender gender);
    Alive getAlive();
    int getAge();













}
