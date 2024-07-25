package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.model.writer.Writer;
import ru.gb.family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;
    private Writer fileHandler;

    public Presenter(View view, Service service, Writer fileHandler) {
        this.view = view;
        this.service = service;
        this.fileHandler = fileHandler;
    }

    public void addHuman(String name, LocalDate dateOfBirth, Gender gender, String fatherName, LocalDate fatherBirthDate, String motherName, LocalDate motherBirthDate) {
        Human father = fatherName != null && !fatherName.isEmpty() ?
                new Human(0, fatherName, fatherBirthDate, Gender.Male, null, null) : null;
        if (father != null) {
            service.getFamilyTree().addElement(father);
        }

        Human mother = motherName != null && !motherName.isEmpty() ?
                new Human(0, motherName, motherBirthDate, Gender.Female, null, null) : null;
        if (mother != null) {
            service.getFamilyTree().addElement(mother);
        }

        Human human = new Human(0, name, dateOfBirth, gender, fatherName, motherName);
        service.getFamilyTree().addElement(human);

        if (father != null) {
            father.addChild(human);
        }

        if (mother != null) {
            mother.addChild(human);
        }

        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void saveToFile() {
        try {
            boolean success = fileHandler.writeToFile(service.getFamilyTree());
            if (success) {
                view.printAnswer("Данные успешно сохранены в файл.");
            } else {
                view.printAnswer("Не удалось сохранить данные в файл.");
            }
        } catch (IOException e) {
            view.printAnswer("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try {
            FamilyTree<Human> loadedTree = (FamilyTree<Human>) fileHandler.readFromFile();
            service.setFamilyTree(loadedTree);
            view.printAnswer("Данные успешно загружены из файла.");
            getHumanListInfo();
        } catch (IOException | ClassNotFoundException e) {
            view.printAnswer("Ошибка при загрузке данных: " + e.getMessage());
        }
    }
}