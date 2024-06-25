package presenter;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.save_and_load.FileHandler;
import view.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Presenter implements Serializable{
    private View view;
    private FamilyTree familyTree;


    public Presenter(View view){
        this.view = view;
        familyTree = new FamilyTree<>();
    }
    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        familyTree.addHuman(new Human(name, gender, birthDate));
        System.out.println("Добавлен(а) "+ name);
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


    //TODO Доделать
//
//    public void saveTree() {
//
//    }
//    public void loadTree() {
//    }
}
