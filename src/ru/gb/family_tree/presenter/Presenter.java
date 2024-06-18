package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.family_tree.FamilyItem;
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
        getFamilyTreeInfo();
    }

    public void addSpouse(String spouse1, String spouse2){
        service.addSpouse(spouse1, spouse2);
        getFamilyTreeInfo();
    }

    public void saveFileByte() throws IOException {
        service.saveFileByte(service.getFamilyTree());

    }

    public void loadFileByte() throws IOException, ClassNotFoundException {
        service.loadFileByte();
    }

    public void sortByName(){
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByAge(){
        service.sortByAge();
        getFamilyTreeInfo();
    }
}
