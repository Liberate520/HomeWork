package com.example.familytree.mvp;

import com.example.familytree.BirthDateComparator;
import com.example.familytree.FamilyTree;
import com.example.familytree.NameComparator;
import com.example.familytree.model.Person;
import com.example.familytree.operations.FileOperations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FamilyTreePresenterImpl implements FamilyTreePresenter {

    private final FamilyTreeView view;
    private FamilyTree<Person> familyTree;
    private final FileOperations fileOps;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public FamilyTreePresenterImpl(FamilyTreeView view, FileOperations fileOps) {
        this.view = view;
        this.familyTree = new FamilyTree<>();
        this.fileOps = fileOps;
    }

    public void setFamilyTree(FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void addPerson(int id, String name, String birthDateStr, String gender) {
        try {
            LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
            Person person = new Person(id, name, birthDate, gender);
            familyTree.addMember(person);
            view.displayMessage("Человек добавлен: " + person);
        } catch (DateTimeParseException e) {
            view.displayMessage("Ошибка: неверный формат даты. Ожидается ДД-ММ-ГГГГ.");
        } catch (NumberFormatException e) {
            view.displayMessage("Ошибка: ID должен быть числовым значением.");
        }
    }

    @Override
    public void displayTree() {
        view.displayTree(familyTree.getAllMembers());
    }

    @Override
    public void sortByName() {
        familyTree.sortBy(new NameComparator());
        view.displayMessage("Древо отсортировано по имени.");
    }

    @Override
    public void sortByBirthDate() {
        familyTree.sortBy(new BirthDateComparator());
        view.displayMessage("Древо отсортировано по дате рождения.");
    }

    @Override
    public void saveToFile(String filename) {
        fileOps.saveToFile(filename, familyTree);
    }

    @Override
    public void loadFromFile(String filename) {
        familyTree = fileOps.loadFromFile(filename);
    }

    @Override
    public void removePersonById(int id) {
        familyTree.removeMemberById(id);
        view.displayMessage("Человек удален: ID = " + id);
    }

    @Override
    public void changePersonId(int oldId, int newId) {
        Person person = familyTree.findPersonById(oldId);
        if (person != null) {
            person.setId(newId);
            view.displayMessage("ID человека изменен: " + person);
        } else {
            view.displayMessage("Человек не найден: ID = " + oldId);
        }
    }

    @Override
    public void setParentChildRelation(int parentId, int childId) {
        Person parent = familyTree.findPersonById(parentId);
        Person child = familyTree.findPersonById(childId);
        if (parent != null && child != null) {
            parent.addChild(child);
            view.displayMessage("Связь родитель-ребенок установлена между ID " + parentId + " и ID " + childId);
            displayTree();
        } else {
            if (parent == null) {
                view.displayMessage("Родитель с ID " + parentId + " не найден.");
            }
            if (child == null) {
                view.displayMessage("Ребенок с ID " + childId + " не найден.");
            }
        }
    }
}
