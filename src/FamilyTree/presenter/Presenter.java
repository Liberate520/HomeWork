package FamilyTree.presenter;

import FamilyTree.familyTree.FamilyTree;
import FamilyTree.view.View;

public class Presenter {
    private View view;

    public Presenter(View view){
        this.view = view;
    }

    public void createFamilyTree(String name){
        FamilyTree familyTree = new FamilyTree();
        familyTree.setName(name);
    }
}
