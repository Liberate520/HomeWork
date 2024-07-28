package family_tree.Interface;

import family_tree.human.Human;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Animal<E> {
    String getFirst_name();
    String getLast_name();
    String getPatronymic();
    ArrayList<E> getChildren();
    E getFather();
    E getMother();
    LocalDate getBirthday();
    String getFullName();
}
