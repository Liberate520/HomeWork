package Presenter;

import java.io.Serializable;
import Model.FamilyTree;
import View.View;
import Presenter.Presenter;

public class Main implements Serializable{
    public static void main(String[] args){
        View view = new View();
        FamilyTree familyTree = new FamilyTree();
        Presenter presenter = new Presenter(view, familyTree);
        view.setPresenter (presenter);
        view.view();
    }
}
