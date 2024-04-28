package family_TREE.presenter;

import family_TREE.model.FamilyTreeService;
import family_TREE.view.View;

public class Presenter {
    private final View view;
    private final FamilyTreeService service;

    public Presenter(View view) {
        this.view = view;
        service = new FamilyTreeService();
    }

    public void addHuman(String name, String gender, String birthDate, long idFather, long idMother) {
        String answer = service.addHuman(name, gender, birthDate, idFather, idMother);
        view.printAnswer(answer);
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.printAnswer(answer);
    }

    public void sortByName(){
        service.sortByName();
        getHumanList();
    }

    public void sortByDeathDate() {
        service.sortByDeathDate();
        getHumanList();
    }
}