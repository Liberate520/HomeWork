package service;

import family_tree.FamilyTree;
import human.Human;

import java.io.Serializable;

public class Service implements Serializable {
    private FamilyTree<Human> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
    }
    public void add(Human human) {
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
