package ru.gb.oop.family_tree.human;

import java.util.Date;
import java.util.List;

public class HumanBuilder {
    private int id;
    public Human newHuman(String name, Sex sex, Date birthDate) {
        return new Human(id++, name, sex, birthDate);
    }
    public Human newHuman(String name, Sex sex, Date birthDate, Date deathDate, List<Human> parents, List<Human> children) {
        return new Human(id++, name, sex, birthDate, deathDate, parents, children);
    }
}
