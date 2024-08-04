package ru.gb2.family_tree7.model.service;

import ru.gb2.family_tree7.model.group.HumanGroup;
import ru.gb2.family_tree7.model.human.Gender;
import ru.gb2.family_tree7.model.human.Human;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Service {
//    private int idHuman;
//    private HumanGroup<Human> group;
//
//    public Service() {
//        group = new HumanGroup<>();
//    }
//
//    public void addHuman(String name){
//        Human human = new Human(idHuman++, name);
//        group.addHuman(human);
//    }
//
//    public String getHumanInfo() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Список родственников: \n");
//
//        Iterator<Human> iterator = group.iterator();
//        while (iterator.hasNext()){
//            Human human = iterator.next();
//            stringBuilder.append(human);
//            stringBuilder.append("\n");
//        }
//        for (Human human: group){
//            stringBuilder.append(human);
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();
//    }
//
//    public void sortByName(){
//        group.sortByName();
//    }
//
//    public List<Human> getHumanList() {
//        return getHumanList(); // Предполагается, что у вас есть список humanList в классе Service
//    }
//
//    public void sortByGender() {
//    }
private static int idCounter = 0; // Для генерации ID
    private HumanGroup<Human> group;

    public Service() {
        group = new HumanGroup<>();
    }

    public void addHuman(Human human) {
        group.addHuman(human);
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список родственников: \n");

        for (Human human : group) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        group.sortByName();
    }

    public void sortByGender() {
        group.sortByGender(); // Предполагается, что метод существует в HumanGroup
    }

    public void sortByDeathDate() {
        group.sortByDeathDate(); // Предполагается, что метод существует в HumanGroup
    }

    public void sortByBirthDate() {
        group.sortByBirthDate(); // Предполагается, что метод существует в HumanGroup
    }

    public void sortByPerents() {
        group.sortByParents(); // Предполагается, что метод существует в HumanGroup
    }

    public void sortByChildren() {
        group.sortByChildren(); // Предполагается, что метод существует в HumanGroup
    }

    public List<Human> getHumanList() {
        return group.getHumanList(); // Предполагается, что у вас есть метод, возвращающий список людей в HumanGroup
    }

    // Метод для создания нового человека и возврата его
    public Human createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        Human human = new Human(getNextId(), name, gender, birthDate, deathDate);
        return human;
    }

    private int getNextId() {
        return idCounter++; // Генерируем уникальный ID
    }
}
