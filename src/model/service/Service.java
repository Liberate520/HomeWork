package model.service;

import model.family_tree.FamilyTree;
import model.file_handler.FileHandler;
import model.human.Gender;
import model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {
    public FamilyTree<Human> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
    }

    public void addHumanInTree(String name, Gender gender,LocalDate localDate){
        Human newHuman = new Human(name, gender,localDate);
        familyTree.addHumanInTree(newHuman);
    }

    public void addChildren(String parants,String name, Gender gender, LocalDate localDate){
        for (Human human: familyTree){
            if(human.getName().equals(parants)){
                human.addChildren(name,gender,localDate);
            }
        }
    }

    public String printAllTree(){
        return familyTree.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }


    public void save(){
        String filePath = "src/model/file_handler/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree,filePath);
    }

    public FamilyTree<Human> load() {
        String filePath = "src/model/file_handler/tree.txt";
        FileHandler fileHandler = new FileHandler();
        familyTree = (FamilyTree<Human>) fileHandler.read(filePath);
        return familyTree;
    }
}
