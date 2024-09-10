package model;
import model.human.*;
import model.saver.*;
import model.tree.*;

import java.time.LocalDate;


public class Service {
    private FamilyTree<Human> familyTree;
    private Human human;
    private FileSaver fileSaver;

    public Service(){
        familyTree = new FamilyTree<Human>();
        human = new Human();

    }
    //public void  setNameTree(String nameTree){
    //   familyTree.setName(nameTree);
   // }
    public void addHuman(String name, Gender gender, LocalDate birthDay){
        human = new Human();
        human.setName(name);
        human.setBirthDay(birthDay);
        human.setGender(gender);
        familyTree.add(human);
    }
    public String printTree(){
        return familyTree.toString();
    }

    public void saveTree(FamilyTree<Human> familyTree){
        fileSaver.save(familyTree);
    }
    public void restoreTree(){
        this.familyTree = fileSaver.restore();
    }
    

//TODO дописать все методы из Human, Tree

}
