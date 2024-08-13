package presenter;

import model.human.Human;
import model.tree.FamilyTree;
import view.View;

import java.util.List;

public class Presenter {

    private View view;
    private Human human;
    private FamilyTree<Human> familyTree;

    public Presenter(View view){
        this.view = view;
        familyTree = new FamilyTree<>();
    }

    public void getHumansList() {
        String answer =  familyTree.getInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        familyTree.sortByName();
        getHumansList();
    }

    public void sortByAge() {
        familyTree.sortByBirthDate();
        getHumansList();
    }

    public void add() {

    }
}
