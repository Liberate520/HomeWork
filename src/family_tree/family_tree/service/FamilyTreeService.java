package family_tree.family_tree.service;

import family_tree.family_tree.model.FamilyTreeModel;
import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreeService {
    private FamilyTreeModel model;

    public FamilyTreeService(FamilyTreeModel model) {
        this.model = model;
    }

    public void addNewFamilyMember(String name, LocalDate dob, Gender gender) {
        Human newMember = new Human(name, dob, gender);
        model.addFamilyMember(newMember);
    }

    public void sortFamilyMembersByName() {
        model.sortFamilyMembersByName();
    }

    public void sortFamilyMembersByBirthDate() {
        model.sortFamilyMembersByBirthDate();
    }

    public List<Human> getFamilyMembers() {
    return model.getFamilyMembers();
}


    // Другие методы для работы с семейным деревом
}
