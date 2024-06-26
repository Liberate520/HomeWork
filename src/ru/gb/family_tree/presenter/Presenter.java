package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.tree.FileHandler;
import ru.gb.family_tree.model.tree.Writeable;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }


    public void showTree() {
        System.out.println(service.ShowTree());
    }
    public FamilyTree getTree(){
        return service.ShowTree();
    }

    public Human findHuman(String firstName) {
        return service.findHuman(firstName);
    }

    public void addElementInTree(Human... humans) {
        service.addHumansInFamTree(humans);
    }

    public void deleteElementFromTree(Human... humans) {
        service.removeHumansFromFamTree(humans);
    }

    public Human createHuman(String firstName, String lastName, LocalDate dob, LocalDate dod, Gender gender, Human father, Human mother, Human... children) {
        return service.createElement(firstName, lastName, dob, dod, gender, father, mother, children);
    }

    public Human createHuman(String firstName, String lastName, LocalDate dob, LocalDate dod, Gender gender, Human father, Human mother) {
        return service.createElement(firstName, lastName, dob, dod, gender, father, mother);
    }

    public Human createHuman(String firstName, String lastName, LocalDate dob, LocalDate dod, Gender gender) {
        return service.createElement(firstName, lastName, dob, dod, gender);
    }


    public void sortByFirstName() {
        service.sortByFirstName();
    }

    public void sortById() {
        service.sortById();
    }

    public void sortByGender() {
        service.sortByGender();
    }

    public void sortByDob() {
        service.sortByDob();
    }

    public void sortByDod() {
        service.sortByDod();
    }

    public void loadTree(String filePath){
        service.load(filePath);
    }

    public void saveTree(FamilyTree tree, String filePath){
        service.save(tree, filePath);
    }
}




