package Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface Methods<T> extends Serializable {
    void setId(int id);
    int getId();
    T getFather();
    T getMother();
    boolean addChild(T human);

    boolean addParent(T human);
    String getName();

    Gender getGender();
    String getSecondName();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();
    T getHusband();
    void setHusband(T human);
}
