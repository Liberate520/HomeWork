package Presenter;

import model.Service;
import model.person.Human;
import model.tree.FamilyTree;
import view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }


    public void loadTree(String path) throws IOException, ClassNotFoundException {
        this.service.loadTree(path);
    }

    public void saveTree(String path) throws IOException, ClassNotFoundException {
        this.service.saveTree(path);
    }

    public void addHuman(String name, String gender, LocalDate birtDay){
        this.service.addHuman(name,gender, birtDay);
    }
}
