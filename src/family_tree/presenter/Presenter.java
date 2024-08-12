package family_tree.presenter;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;
import family_tree.model.human.HumanService;
import family_tree.model.human.Gender;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private HumanService service;

    public Presenter(View view) {
        this.view = view;
        service = new HumanService();
    }

    public void addHuman(String surname, String name, String middleName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        service.addHuman(surname, name, middleName, gender, birthDate, deathDate);
        getFamilyTreeInfo();
    }

    public void addSpouse(long humanId1, long humanId2) {
        service.addSpouse(humanId1, humanId2);
        getFamilyTreeInfo();
    }

    public void deleteSpouse(long humanId1, long humanId2) {
        service.deleteSpouse(humanId1, humanId2);
        getFamilyTreeInfo();
    }

    public void setRelationship(long childId, long parentId) {
        service.setRelationship(childId, parentId);
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        String answer = service.getFamilyTreeInfo();
        view.printAnswer(answer);
    }

    public void loadTree() {
        service.load();
    }

    public void saveTree() {
        service.save();
    }
}
