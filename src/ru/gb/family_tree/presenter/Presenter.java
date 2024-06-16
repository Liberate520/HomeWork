package ru.gb.family_tree.presenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import ru.gb.family_tree.model.item.FamilyTreeItem;
import ru.gb.family_tree.model.item.Gender;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

public class Presenter<E extends FamilyTreeItem<E>> {

    private View view;
    private Service<E> service;

    public Presenter(View view) {
        this.view = view;
        service = new Service<>();
    }    

    public void addItem(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, E father, E mother) {
        service.addItem(name, gender, birthDate, deathDate, father, mother);
        //какой-то ответ
        getTreeInfo();
    }

    public void getTreeInfo() {
        String info = service.toString();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getTreeInfo();
    }

    public void sortBySpouse() {
        service.sortBySpouse();
        getTreeInfo();
    }   

    public void saveTree() throws FileNotFoundException, IOException {
        service.saveTree();
        getTreeInfo();
    }

    public void loadTree() throws FileNotFoundException, ClassNotFoundException, IOException {
        service.loadTree();
        getTreeInfo();
    }      
}
