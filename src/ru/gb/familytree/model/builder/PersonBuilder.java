package ru.gb.familytree.model.builder;

import ru.gb.familytree.model.human.Gender;
import ru.gb.familytree.model.human.Human;

public class PersonBuilder {

    public Human build(String name, int age, Gender gender) {
        return new Human(name, age, gender);
    }
}
