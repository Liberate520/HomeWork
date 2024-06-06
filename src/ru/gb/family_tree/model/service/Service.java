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

    public void addChildren(String parentString, String childString){
        Human parent = null;
        Human child = null;
        for(Human human: familyTree){
            if(human.getName().equals(parentString)){
                parent = human;
            }
        }
        for(Human human: familyTree){
            if(human.getName().equals(childString)){
                child = human;
            }
        }
        parent.getChildren().add(child);
        child.getParents().add(parent);
    }

    public void addSpouse(String spouseFirstString, String spouseSecondString){
        Human spouseFirst = null;
        Human spouseSecond = null;
        for(Human human: familyTree){
            if(human.getName().equals(spouseFirstString)){
                spouseFirst = human;
            }
        }
        for(Human human: familyTree){
            if(human.getName().equals(spouseSecondString)){
                spouseSecond = human;
            }
        }
        Human spouseTempFirst = spouseFirst.getSpouse();
        spouseTempFirst = spouseSecond;
        Human spouseTempSecond = spouseSecond.getSpouse();
        spouseTempSecond = spouseFirst;
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
