package family_tree.model.person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    void addChildFromUnknownPartner(T child);

    boolean addChildFromThisPartner(T partner, T child);

    ArrayList<T> getKidsFromPartner(T partner);

    T findChildByName(String name);

    ArrayList<T> getListOfChildren();

    T getMother();
    void setParent(T parent);
    T getFather();
    String getName();
    void setDeadDate(LocalDate dod);
    void setDateOfBirth(LocalDate dob);
    void setPartner(T partner);
    List<T> getListOfPartner();
    int getAge();
    T getPartner();
    Gender getGender();
    long getId();
    void setId(long id);
    int getGeneration();
    void setGeneration(int generation);
    LocalDate getDateOfBirth();
}
