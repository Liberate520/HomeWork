package family_tree.family_tree.model;

import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FamilyTreeModel {
    private List<Human> familyMembers;

    public FamilyTreeModel(List<Human> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public List<Human> getFamilyMembers() {
        return familyMembers;
    }

    // Добавил новый метод в модель для создания и добавления нового члена семьи
    public void createAndAddFamilyMember(String name, LocalDate dob, Gender gender) {
        Human newMember = new Human(name, dob, gender);
        addFamilyMember(newMember);
    }

    public void addFamilyMember(Human member) {
        familyMembers.add(member);
    }

    public void sortFamilyMembersByName() {
        Collections.sort(familyMembers, Comparator.comparing(Human::getName));
    }

    public void sortFamilyMembersByBirthDate() {
        Collections.sort(familyMembers, Comparator.comparing(Human::getDateOfBirth));
    }

}
