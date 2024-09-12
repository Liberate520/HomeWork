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
        System.out.println(name + " добавлен!");
    }
    public void printTree(){
        System.out.println(familyTree.toString());
    }

    public void saveTree(FamilyTree<Human> familyTree){
        fileSaver.save(familyTree);
        System.out.println("Дерево сохранено!");
    }
    public void restoreTree(){
        this.familyTree = fileSaver.restore();
        System.out.println("Дерево загружено!");
    }
    public Human getHuman(int id){
        return familyTree.getById(id);
    }
    

//TODO дописать сортировка и поиск, родственная связь методы из Human, Tree

}
