package seminar2.presenter;

import seminar2.View.commands.View;
import seminar2.model.Human.Gender;
import seminar2.model.Human.Human;
import seminar2.model.Tree.FamilyTree;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private FamilyTree tree;
    private Human human;

    public Presenter(View view) {
        this.view = view;
        tree = new FamilyTree();
        human = new Human(null, null, null, null, null, null,null, null);
    }

    public void addRelative(String name, String surname, Gender valueOf, LocalDate dateOfBirth) {
        Human human = new Human(name, surname, valueOf, dateOfBirth);
        tree.add(human);
        tree.getInfo();
    }

    public void getByNameSurname(String name, String surname) {
        tree.getByNameSurname(name, surname);
    }


    public void getByOneFamily(String surname) {
        tree.getByOneFamily(surname);
    }

    public void getTreeInfo() {
        String answer = tree.getInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sorBySurname() {
        tree.sortBySurname();
    }

    public void sortByAge() {
        tree.getInfoSortByAge();
    }
}
