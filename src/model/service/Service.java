package model.service;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {
    private FamilyTree<Human> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
    }
    public void addHuman(Human human) {
        familyTree.add(human);
    }

    public void addHuman(String name, LocalDate dateOfBirthday, Gender gender){
        Human human = new Human(name, dateOfBirthday, gender);
        familyTree.add(human);
    }
    public String getFamilyTreeInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список дерева:\n");
        for (Human human: familyTree) {
            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void sortByName(){
        familyTree.sortByName();
    }
    public void sortByAge(){
        familyTree.sortByAge();
    }

    @Override
    public String toString() {
        return getFamilyTreeInfo();
    }
}
