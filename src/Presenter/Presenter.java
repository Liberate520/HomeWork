package Presenter;

import Model.FamilyTree;
import Model.FileHandler;
import Model.Gender;
import View.ConsoleUI;
import View.View;
import Model.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class Presenter {
    private ConsoleUI view;
    private FamilyTree familyTree;

    public Presenter(ConsoleUI view) {
        this.view = view;
        this.familyTree = new FamilyTree<>();
    }


    public void addHuman(String name, LocalDate dob, Gender gender) {
        Human newHuman = new Human(name, dob, gender);
        if (familyTree.findByName(name) == null) {
            familyTree.addHuman(newHuman, null, null);
            view.printAnswer("Человек добавлен успешно.");
        } else {
            view.printAnswer("Человек с таким именем уже существует в дереве.");
        }
    }
    public void addFather(String childName, String fatherName, LocalDate dob, Gender gender) {
        Human father = new Human(fatherName, dob, gender);
        Human child = familyTree.findByName(childName);
        if (child != null) {
            familyTree.addFather(child, father);
            view.printAnswer("Отец успешно добавлен");
        } else {
            view.printAnswer("Ребёнок не найден");
        }
    }
    public void addMother(String childName, String motherName, LocalDate dob, Gender gender) {
        Human mother = new Human(motherName, dob, gender);
        Human child = familyTree.findByName(childName);
        if (child != null) {
            familyTree.addMother(child, mother);
            view.printAnswer("Мать успешно добавлена");
        } else {
            view.printAnswer("Ребёнок не найден");
        }
    }
    public void save(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, "C:\\Users\\Podgaynyy\\Desktop\\Programming\\GeekBrains\\Программист\\" +
                "Java\\OOP\\homeWork_Java_OOP\\save");
    }
    public void printFamilyTree() {
        String treeRepresentation = familyTree.toString();
        view.printAnswer(treeRepresentation);
    }
    public void save(String filePath) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filePath);
    }
}

