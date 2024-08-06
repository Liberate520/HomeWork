package model.service;

import model.familiTree.FamilyTree;
import model.human.Gender;
import model.human.Human;

import java.time.LocalDate;
import java.util.ArrayList;

public class Service {

    private FamilyTree<Human> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }


    public void addHuman(String name, Gender gender, LocalDate dateOfBirth) {
        Human human = new Human(name, gender, dateOfBirth);
        human.setName(name);
        human.setGender(gender);
        human.setDateOfBirth(dateOfBirth);
        familyTree.addHuman(human);

    }




    public void sortByName() { // сортировка по имени
        familyTree.sortByName();
    }

    public void sortByAge() { // сортировка по возрасту
        familyTree.sortByAge();
    }

    public String getHumanListInfo() {
        // метод для вывода информации о человеке
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;

        for (Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
            count++;
        }
        System.out.println("Генеалогическое древо (размер = " + count + "):");
        return stringBuilder.toString();
    }




}
