package family_TREE.presenter;

import family_TREE.model.FamilyTreeService;
import family_TREE.view.View;

public class Presenter {
    private final View view;
    private final FamilyTreeService service;

    public Presenter(View view) {
        service = new FamilyTreeService();
        this.view = view;
    }

    public void addHuman(String name, String gender, String birthDate, long idFather, long idMother) {
        String answer = service.addHuman(name, gender, birthDate, idFather, idMother);
        view.print(answer);
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }
}