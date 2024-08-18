package my_fam_tree.model;

import java.time.LocalDate;
import java.util.List;

public interface InFamily<T extends InFamily> {
    String getName();
    LocalDate getDateOfBirth();
    T getFather();
    T getMother();
    void setFather(T father);
    void setMother(T mother);
    List<T> getChildren();
    void addChild(T child);
}
