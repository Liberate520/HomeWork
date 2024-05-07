package model.FamilyTree;

import model.Human.Gender;
import model.Human.TreeNode;
import writer.FileHandler;
import writer.Writeable;

import java.io.Serializable;
import java.time.LocalDate;

public class Service<E extends TreeNode<E>> extends FileHandler {

    FamilyTree<E> tree = new FamilyTree<>();



    public void addHuman(String name, String secondName, Gender gender, LocalDate birthDate,LocalDate deathDate,
                         String motherName, String fatherName){
        tree.createHuman(name, secondName, gender, birthDate, deathDate, motherName, fatherName);

    }

    public String getHumanListInfo(){
        return tree.getInfo();
    }
    public void sortByName(){
        tree.sortByName();
    }
    public void sortByAge(){
        tree.sortByBirthDate();
    }


    public void loadFamilyTree(){
        tree = (FamilyTree<E>) read();
    }

    public void saveFamilyTree(){
        save(tree);
    }
}