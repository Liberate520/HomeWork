package Presenter;

import Model.FamilyTree;
import Model.Human;
import View.View;

public class Presenter {
    View view;
    FamilyTree familyTree;

    public Presenter(View view, FamilyTree familyTree) {
        this.view = view;
        this.familyTree = familyTree;

    }

    public void getHumanByName(String name) {
        FamilyTree.getHumanByName(name);
    }
}


