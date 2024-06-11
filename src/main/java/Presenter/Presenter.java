package Presenter;

import model.Service;
import model.tree.FamilyTree;
import view.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void CreateTree(){
        this.service.CreateTree();
    }
    public FamilyTree LoadTree(String path) throws IOException, ClassNotFoundException {
        return this.service.LoadTree(path);
    }
}
