package Family_Tree.presenter;

import Family_Tree.model.FamilyTree.FamilyTree;
import Family_Tree.view.View;

public class Presenter {
    private final View view;
    private final FamilyTree familyTree;

    public Presenter(View view) {
        this.view = view;
        familyTree = new FamilyTree();
    }

    public void getInfo() {
        String answer = familyTree.getInfo();
        view.PrintAnswer(answer);
    }

    public void sortByAge(){
        familyTree.sortByAge();
        getInfo();
    }
    public void sortByName(){
        familyTree.sortByName();
        getInfo();
    }

}
