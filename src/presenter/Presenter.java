package presenter;

import model.FamilyTree;
import model.Gender;
import model.Human;
import service.FamilyTreeService;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private FamilyTreeService<Human> service;
    private FamilyTree<Human> familyTree;

    public Presenter(View view) {
        this.view = view;
        this.familyTree = new FamilyTree<>();
        this.service = new FamilyTreeService<>();
    }

    public void addHuman(String name, LocalDate dateOfBirth, Gender gender, String fatherName, LocalDate fatherBirthDate, String motherName, LocalDate motherBirthDate) {
        Human father = fatherName != null && !fatherName.isEmpty() ? new Human(fatherName, Gender.MALE, fatherBirthDate) : null;
        Human mother = motherName != null && !motherName.isEmpty() ? new Human(motherName, Gender.FEMALE, motherBirthDate) : null;

        if (father != null && familyTree.getMember(fatherName) == null) {
            familyTree.addMember(father);
        } else {
            father = (Human) familyTree.getMember(fatherName);
        }

        if (mother != null && familyTree.getMember(motherName) == null) {
            familyTree.addMember(mother);
        } else {
            mother = (Human) familyTree.getMember(motherName);
        }

        Human human = new Human(name, gender, dateOfBirth);
        familyTree.addMember(human);

        if (father != null) {
            father.addChild(human);
        }

        if (mother != null) {
            mother.addChild(human);
        }

        getHumanListInfo();
    }

    public void getHumanListInfo() {
        StringBuilder info = new StringBuilder();
        for (Human human : familyTree) {
            info.append(human).append("\n");
        }
        view.printAnswer(info.toString());
    }

    public void sortByAge() {
        familyTree.sortByBirthDate();
        getHumanListInfo();
    }

    public void sortByName() {
        familyTree.sortByName();
        getHumanListInfo();
    }
}
