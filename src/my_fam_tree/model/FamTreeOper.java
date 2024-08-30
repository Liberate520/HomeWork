package my_fam_tree.model;

import java.io.Serializable;
import java.util.List;

public interface FamTreeOper<T extends InFamily<T>> extends Serializable{
    void addRelative(T relative);
    T findHuman(String name);
    List<T> getRelatives();
    void sortName();
    void sortBirthDate();
}
