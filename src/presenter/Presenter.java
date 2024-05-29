package presenter;

import model.FamilyTreeService;
import model.familyTree.FamilyTree;
import model.human.Human;
import view.View;

public class Presenter {
    private View view;
    private FamilyTreeService service;

    public Presenter(View view, FamilyTree<Human> familyTree) {
        service = new FamilyTreeService(familyTree);
        this.view = view;
    }

    public void addHuman(String name, String secondName, String gender, String birthDate, long idFather, long idMother) {
        String answer = service.addHuman(name, secondName, gender, birthDate);
        view.print(answer);
    }

    public void addHuman(String name, String secondName, String gender, String birthDate) {
        String answer = service.addHuman(name, secondName, gender, birthDate);
        view.print(answer);
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }

    public void sortByDayOfBirth() {
        service.sortByDayOfBirth();
        getHumanList();
    }

    public void sortByName() {
        service.sortByName();
        getHumanList();
    }

    public void viewTree() {
        service.viewTree();
        getHumanList();
    }

    public void loadTree() {
        service.load();
        getHumanList();
    }

}