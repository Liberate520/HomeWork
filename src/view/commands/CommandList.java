package view.commands;

import model.human.Human;
import model.human.Sex;

import java.time.LocalDate;
import java.util.List;

public interface CommandList {

    void add(String name, LocalDate birthDate, LocalDate deathDate, Sex sex, Human father, Human mother);

    List<Human> getFamilyTree();

    List<Human> findByName(String name);

    void sortByName();

    void sortByBirthDate();

    void sortByAge();

    String printList(List<Human> list);

    void save();

    void load();

    void setBirthDate(Human human, LocalDate birthDate);

    void setDeathDate(Human human, LocalDate deathDate);

    void setParents(Human human, Human father, Human mother);
}
