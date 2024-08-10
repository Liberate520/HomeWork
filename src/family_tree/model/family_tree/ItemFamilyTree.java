package family_tree.model.family_tree;

import family_tree.model.human.enum_for_human.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface ItemFamilyTree<T> extends Serializable {
    void setId(long id);
    long getId();
    String getFirstName();
    String getPatronymic();
    String getLastName();
    Gender getGender();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    List<T> getParents();
    List<T> getChildren();
}
