import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public interface TreeNode <T> extends Serializable {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChild(T E);
    boolean addParent(T E);
    String getName();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void setSpouse(T E);
    Gender getGender();
    void setFather(T E);
    void setMother(T E);
    String getSurname();

}

