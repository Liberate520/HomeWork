package model;
import model.human.*;
import model.saver.*;
import model.tree.*;

import java.time.LocalDate;


public class Service {
    private FamilyTree<Human> familyTree;
    private Human human;
    private FileSaver fileSaver;
    final static String filePath = "src.model.saver.back_up_tree.but";

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
        FileSaver fileSaver = new FileSaver();
        fileSaver.save(familyTree);
        System.out.println("Дерево сохранено!");
    }
    public void restoreTree(){
        FileSaver fileSaver = new FileSaver();
        this.familyTree = fileSaver.restore();
        System.out.println("Дерево загружено!");
    }
    public Human getHuman(int id){
        return familyTree.getById(id);
    }
    public void setWedding(int h, int w){
        familyTree.setWedding(h,w);
    }
    public void setDivorce(int h, int w){
        familyTree.setDivorce(h, w);
    }
    public void setParent(int parentId, int humanId){
        Human human = getHuman(humanId);
        Human parent = getHuman(parentId);
        human.addParent(parent);
    }
    public void setChild(int childId, int humanId){
        Human human = getHuman(humanId);
        Human child = getHuman(childId);
        human.addChildren(child);
    }
    public void removeHuman(int human){
        familyTree.remove(human);
    }
    public void saveTree(){
        FileSaver fileSaver = new FileSaver();
        fileSaver.setPath(filePath);
        fileSaver.save(this.familyTree);
    }
    public void loadTree(){
        FileSaver fileSaver = new FileSaver();
        fileSaver.setPath(filePath);
        familyTree =  fileSaver.restore();
    }
    public void sortById(){
        familyTree.sortById();
    }
    public void sortByName(){
        familyTree.sortByName();
    }
    public void sortByAge(){
        familyTree.sortByBirsday();
    }
    public void setDeathDay(int humanId, LocalDate deathDay){
        Human human = getHuman(humanId);
        human.setDeathDay(deathDay);
    }
    



}
