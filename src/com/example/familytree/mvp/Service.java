package com.example.familytree.mvp;

import com.example.familytree.model.Person;
import com.example.familytree.operations.FileOperations;
import com.example.familytree.service.FamilyTreeService; // Импортируем FamilyTreeService
import com.example.familytree.FamilyTree; // Импортируем FamilyTree

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Service {
    private final FamilyTree<Person> familyTree;
    private final FamilyTreeService service;
    private final FamilyTreeView view;
    private final FileOperations fileOps;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Service(FamilyTreeView view, FileOperations fileOps) {
        this.view = view;
        this.fileOps = fileOps;
        this.familyTree = new FamilyTree<>();
        this.service = new FamilyTreeService(fileOps); // Используем FamilyTreeService
        service.setFamilyTree(familyTree); // Устанавливаем FamilyTree в FamilyTreeService
    }

    public void addPerson(int id, String name, String birthDateStr, String gender) {
        try {
            LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
            Person person = new Person(id, name, birthDate, gender);
            service.addPerson(person);
            view.displayMessage("Человек добавлен: " + person);
        } catch (Exception e) {
            view.displayMessage("Ошибка: " + e.getMessage());
        }
    }

    public void displayTree() {
        view.displayTree(service.getFamilyTree().getAllMembers());
    }

    public void sortByName() {
        service.sortByName();
        view.displayMessage("Древо отсортировано по имени.");
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        view.displayMessage("Древо отсортировано по дате рождения.");
    }

    public void saveToFile(String filename) {
        service.saveToFile(filename);
    }

    public void loadFromFile(String filename) {
        service.loadFromFile(filename);
    }

    public void removePersonById(int id) {
        service.removePersonById(id);
        view.displayMessage("Человек удален: ID = " + id);
    }

    public void changePersonId(int oldId, int newId) {
        if (service.getFamilyTree().findPersonById(oldId) != null) {
            service.changePersonId(oldId, newId);
            view.displayMessage("ID человека изменен: ID = " + oldId + " на ID = " + newId);
        } else {
            view.displayMessage("Человек не найден: ID = " + oldId);
        }
    }

    public void setParentChildRelation(int parentId, int childId) {
        if (service.getFamilyTree().findPersonById(parentId) != null && service.getFamilyTree().findPersonById(childId) != null) {
            service.setParentChildRelation(parentId, childId);
            view.displayMessage("Связь родитель-ребенок установлена между ID " + parentId + " и ID " + childId);
            displayTree();
        } else {
            if (service.getFamilyTree().findPersonById(parentId) == null) {
                view.displayMessage("Родитель с ID " + parentId + " не найден.");
            }
            if (service.getFamilyTree().findPersonById(childId) == null) {
                view.displayMessage("Ребенок с ID " + childId + " не найден.");
            }
        }
    }
}
