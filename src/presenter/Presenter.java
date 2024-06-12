package presenter;
import model.writer.human.Human;
import model.writer.human.Gender;
import model.writer.family_tree.FamilyTree;
import view.View;


import java.time.LocalDate;



public class Presenter {
    private View view;
    private FamilyTree<Human> tree;

    public Presenter(View view) {
        this.view = view;
        tree = new FamilyTree<>();
    }

    public void addMember(String name, Gender gender, LocalDate birthDate) {
        Human member = new Human(name, gender, birthDate);
        tree.add(member);
        view.printAnswer("Член семьи добавлен: " + member.getInfo());
    }

    public void getTreeInfo() {
        view.printAnswer(tree.getInfo());
    }

    public void sortByName() {
        tree.sortByName();
        getTreeInfo();
    }

    public void sortByBirthDate() {
        tree.sortByBirthDate();
        getTreeInfo();
    }
}
