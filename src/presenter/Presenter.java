package presenter;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private FamilyTree familyTree;
    private Human human;
    private Gender gender;
    private LocalDate birthDate;



    public Presenter(View view){
        this.view = view;
        familyTree = new FamilyTree();
        human = new Human();
    }
    public void addHuman() {
        familyTree.addHuman(human);
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        String info = familyTree.getHumansInfo();
        view.printAnswer(info);
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
        getFamilyTreeInfo();
    }

    public void sortByName() {
        familyTree.sortByName();
        getFamilyTreeInfo();
    }
}
