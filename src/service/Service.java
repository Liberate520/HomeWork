package service;

import familytree.FamilyTree;
import familytree.dog.Dog;
import human.Human;

import java.io.Serializable;

public class Service implements Serializable {
    private FamilyTree<Human> familyTree;
    private FamilyTree<Dog> dogFamilyTree;

    public Service() {
        FamilyTree familyTree = new FamilyTree<>();
    }

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void setService(FamilyTree<Dog> dogFamilyTree) {
        this.dogFamilyTree = dogFamilyTree;
    }

    public void addFamilyMemberHuman(Human member) {
        familyTree.add(member);
    }

    public void addFamilyMemberDog(Dog member) {
        dogFamilyTree.add(member);
    }

    public String getTreeInfoHuman() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family members: \n");
        for (Human member: familyTree) {
            stringBuilder.append(member.getInfo());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getTreeInfoDog() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dogs: \n");
        for (Dog member: dogFamilyTree) {
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
