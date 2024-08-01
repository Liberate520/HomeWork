package ru.gb2.family_tree7.model.service;

import ru.gb2.family_tree7.model.group.HumanGroup;
import ru.gb2.family_tree7.model.human.Human;

import java.util.Iterator;

public class Service {
    private int idHuman;
    private HumanGroup<Human> group;

    public Service() {
        group = new HumanGroup<>();
    }

    public void addStudent(String name, int age){
        Human human = new Human(idHuman++, name, age);
        group.addHuman(human);
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список родственников: \n");

        Iterator<Human> iterator = group.iterator();
        while (iterator.hasNext()){
            Human human = iterator.next();
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        for (Human human: group){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        group.sortByName();
    }

    public void sortByAge(){
        group.sortByAge();
    }

    public void addHuman(String name, int age) {
    }
}
