package model.service;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;

import java.time.LocalDate;

public class Service {

    private int memberId;
    private FamilyTree<Human> family;

    public Service() {
        family = new FamilyTree<>();
    }

    public void addMember(String name, LocalDate dob, Gender gender) {
        Human familyMember = new Human(memberId++, name, gender, dob);
        family.addMember(familyMember);
    }

    public String getMembersInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Члены семьи:\n");

        for (Human human: family) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        family.sortByName();
    }

    public void sortByAge() {
        family.sortByAge();
    }

}
