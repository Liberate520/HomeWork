package com.example.familytree.mvp;

import com.example.familytree.FamilyTree;
import com.example.familytree.model.Person;
import com.example.familytree.service.FamilyTreeService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class FamilyTreePresenterImpl implements FamilyTreePresenter {

    private final FamilyTreeView view;
    private final FamilyTreeService service;

    public FamilyTreePresenterImpl(FamilyTreeView view, FamilyTreeService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void addPerson(int id, String name, String birthDateStr, String gender) {
        try {
            LocalDate birthDate = LocalDate.parse(birthDateStr, FamilyTreeService.formatter);
            Person person = new Person(id, name, birthDate, gender);
            service.addPerson(person);
            view.displayMessage("Человек добавлен: " + person);
        } catch (DateTimeParseException e) {
            view.displayMessage("Ошибка: неверный формат даты. Ожидается ДД-ММ-ГГГГ.");
        } catch (NumberFormatException e) {
            view.displayMessage("Ошибка: ID должен быть числовым значением.");
        }
    }

    @Override
    public void displayTree() {
        view.displayTree(service.getFamilyTree().getAllMembers());
    }

    @Override
    public void sortByName() {
        service.sortByName();
        view.displayMessage("Древо отсортировано по имени.");
    }

    @Override
    public void sortByBirthDate() {
        service.sortByBirthDate();
        view.displayMessage("Древо отсортировано по дате рождения.");
    }

    @Override
    public void saveToFile(String filename) {
        service.saveToFile(filename);
    }

    @Override
    public void loadFromFile(String filename) {
        service.loadFromFile(filename);
    }

    @Override
    public void removePersonById(int id) {
        service.removePersonById(id);
        view.displayMessage("Человек удален: ID = " + id);
    }

    @Override
    public void changePersonId(int oldId, int newId) {
        if (service.getFamilyTree().findPersonById(oldId) != null) {
            service.changePersonId(oldId, newId);
            view.displayMessage("ID человека изменен: ID = " + oldId + " на ID = " + newId);
        } else {
            view.displayMessage("Человек не найден: ID = " + oldId);
        }
    }

    @Override
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

    @Override
    public void setFamilyTree(FamilyTree<Person> familyTree) {
        service.setFamilyTree(familyTree);
    }
}
