package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.family_tree.FileHandler;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;

import java.io.IOException;

public class Service {
    private FamilyTree<Human> familyTree;

    public Service() {
       familyTree = new FamilyTree<>();

    }

    public void addHuman(String name, String birth, Gender gender){
        Human human = new Human(name, birth, gender);
        familyTree.addHuman(human);
    }

    public void addChildren(Human parent, Human child){
        parent.getChildren().add(child);
        child.getParents().add(parent);
    }

    public void addSpouse(Human spouse1, Human spouse2){
        Human sp1 = spouse1.getSpouse();
        sp1 = spouse2;
        Human sp2 = spouse2.getSpouse();
        sp2 = spouse1;
    }

    public void saveFileByte(FamilyTree familyTree) throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.saveFileByte(familyTree);
    }

    public void loadFileByte() throws IOException, ClassNotFoundException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.loadFileByte();
    }

    public String getFamilyTreeInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: familyTree ){
            stringBuilder.append(human);
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

    public FamilyTree getFamilyTree(){
        return familyTree;
    }
}
