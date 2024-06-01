package Family_tree.Tree;

import java.time.LocalDate;
import java.util.List;

import Family_tree.Humans.Gender;

public interface GenusTree<T> {
    void add(String name, Gender gender, LocalDate birthDate);
    void add(T value);
    List<T> searchByName(String name);
}
