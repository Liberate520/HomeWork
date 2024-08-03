package familyTree.familyTree;

import familyTree.human.Gender;
import familyTree.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<E> extends Serializable {
    String getLastName();
    String getFirstname();
    String getPatronymic();
    Gender getGender();
    LocalDate getDayBirth();
    LocalDate getDayDeath();
    E getFather();
    E getMother();
    List<E> getChildren();
    String getPlaceBorn();
    long getID();
    int getAge();
    String getFIO(E human);
    List<E> getParents();
    void addChild(E human);
    void addParent(E human);

    void setID(long id);
    void setLastName(String lastName);
    void setFirstname(String firstname);
    void setPatronymic(String patronymic);
    void setGender(Gender gender);
    void setDayBirth(LocalDate dayBirth);
    void setDayDeath(LocalDate dayDeath);
    void setFather(E father);
    void setMother(E mother);
    void setChildren(List<E> children);
    void setPlaceBorn(String placeBorn);
}
