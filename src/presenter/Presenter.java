package presenter;

import model.service.Service;
import view.Auxiliary.HumanData;
import view.View;

public class Presenter {
    private final View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(HumanData humanData) {
        service.addHuman(humanData);
    }

    public void addParent(HumanData humanData, int id) {
        service.addParent(humanData, id);
    }

    public void addChild(HumanData humanData, int id) {
        service.addChild(humanData, id);
    }

    public void getFamilyTreeInfo() {
        String answer = service.getFamilyTreeInfo();
        view.printAnswer(answer);
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByID() {
        service.sortByID();
        getFamilyTreeInfo();
    }

    public void loadTree() {
        service.loadTree();
    }

    public void saveTree() {
        service.saveTree();
    }
}
