package family_tree.model.Interface;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Animal<E> {
    String getFirst_name();
    String getLast_name();
    String getPatronymic();
    ArrayList<E> getChildren();
    E getFather();
    void setFather(E human);
    void setMother(E human);
    E getMother();
    LocalDate getBirthday();
    String getFullName();
    int getId();
    void setId(int id);
    void addChild(E child);
    void removeChild(E child);
    Gender getGender();
    void setGender(Gender gender);
}
