package model.Service;

import java.time.LocalDate;

import model.FamilyTree.FamilyTree;
import model.FamilyTree.ItemFamilyTree;
import model.Humans.Gender;
import model.Humans.Human;
import model.builder.HumanBuilder;

public class Service<U extends ItemFamilyTree<U>> {
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;

    public Service() {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
    }

    public void addHuman(String name, LocalDate dateOfBorn, LocalDate dateOfDeath, Gender gender) {
        Human human = humanBuilder.build(name, dateOfBorn, dateOfDeath, gender);
        familyTree.addHuman(human);
    }

    public void sortByGender() {
        familyTree.sortByGender();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public String getHumansInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное дерево:\n");
        for (Human human : familyTree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
