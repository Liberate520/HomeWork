package family_tree;

import human.Gender;
import human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeElement<T> extends Serializable {

    long getId();  void setId(long id);
    String getName(); void setName(String name);

    boolean addChild(T ciild); boolean addParents (T parent);

    Gender getGender();  void setGender(Gender gender);

    T getMother() ;  void setMother(T mother);

    T getFather(); void setFather(T father);
    List<T> getChildren();List<T> getParents();

    LocalDate getBrithDate();LocalDate getDeathDate();
}
