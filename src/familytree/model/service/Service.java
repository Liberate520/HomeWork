package familytree.model.service;

import familytree.model.familytree.FamilyTree;
import familytree.model.familytree.FamilyTreeElement;
import familytree.model.human.Human;

import java.io.Serializable;

public class Service implements Serializable {
    private FamilyTree<Human> familyTree;

    public Service() {
        FamilyTree<Human> familyTree = new FamilyTree<>();
    }

    public Service(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public void addFamilyMember(Human member) {
        familyTree.add(member);
    }

    public String getTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family members: \n");
        for (Human member: familyTree) {
            stringBuilder.append(member.getInfo());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }
}
