package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private long nextId;

    public Service() {
        familyTree = new FamilyTree<>();
        nextId = 1; // Инициализируем начальный ID
    }

    public void addHuman(String name, LocalDate dateOfBirth, Gender gender, String fatherName, String motherName) {
        Human human = new Human(nextId++, name, dateOfBirth, gender, fatherName, motherName); // Используем автоинкремент
        familyTree.addElement(human);
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");

        for (Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }
}
