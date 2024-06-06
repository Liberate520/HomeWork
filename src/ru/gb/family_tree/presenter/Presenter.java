package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String birth, Gender gender){
        service.addHuman(name, birth, gender);
        System.out.println("Добавлен " + name);
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        String info = service.getFamilyTreeInfo();
        view.printAnswer(info);
    }

    public FamilyTree getFamilyTree(){
        return service.getFamilyTree();
    }

    public void addChildren(String parent, String child){
        service.addChildren(parent, child);
    }

    public void addSpouse(String spouse1, String spouse2){
        service.addSpouse(spouse1, spouse2);
    }

    public void saveFileByte(Service tree) throws IOException {
        service.saveFileByte(service.getFamilyTree());
    }

    public void loadFileByte() throws IOException, ClassNotFoundException {
        service.loadFileByte();
    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortByAge(){
        service.sortByAge();
    }
}
