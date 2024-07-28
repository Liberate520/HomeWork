package ru.gb.familytree.model.service;

import ru.gb.familytree.model.builder.PersonBuilder;
import ru.gb.familytree.model.human.Gender;
import ru.gb.familytree.model.human.Human;
import ru.gb.familytree.model.human.saveload.FileHandler;
import ru.gb.familytree.model.human.tree.TreeFamily;


public class Service {

    private TreeFamily<Human> treeFamily;
    //private PersonBuilder personBuilder;
    private FileHandler fileHandler;

    public Service() {
        treeFamily = new TreeFamily<>();
        //personBuilder = new PersonBuilder();
        fileHandler = new FileHandler();
    }

    public void addPerson(String name, int age, Gender gender){
        Human human = new Human(name, age, gender);
        treeFamily.add(human);
    }

    public String getListOfHuman() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей в древе:\n");
        for (Human human : treeFamily) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        treeFamily.sortTreeByName();
    }

    public void sortByAge() {
        treeFamily.sortTreeByAge();
    }

    public void saveTree() {
        fileHandler.save(treeFamily, "file"); //должно быть как-то иначе...
    }

    public void loadTree() {
        fileHandler.read("file"); //должно быть как-то иначе...
    }
}
