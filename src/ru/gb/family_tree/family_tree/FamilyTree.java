package ru.gb.family_tree.family_tree;

import java.util.ArrayList;
import java.util.List;
import ru.gb.family_tree.human.Human;

public class FamilyTree {
    //список людей
    private List<Human> people;

    public FamilyTree() {
        people = new ArrayList<>();
    }

    // добавление человека в дерево
    public void addHuman(Human human) {
        people.add(human);
    }

    // поиск человека по имени
    public Human findPersonByName(String firstName, String lastName) {
        for (Human person : people) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }
}
