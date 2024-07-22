//package ru.gb.family_tree;

import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import writer.FileHandler;

//import java.io.Serializable;

public class Main {
    public static void main(String[] args) {
        String filepath = "src/family_tree.txt";
        FamilyTree familyTree = fillingFamilyTree();
        System.out.println(familyTree);
//        save(familyTree, filepath);
        /*
        fillingFamilyTree(familyTree);
        System.out.println(familyTree.toString());
        */
    }
//    static void  save(FamilyTree familyTree, String filePath){
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.save((Serializable) familyTree, filePath);
//    }
//    static FamilyTree read(String filePath){
//        FileHandler fileHandler = new FileHandler();
//        return (FamilyTree) fileHandler.read(filePath);
//    }

    public static FamilyTree fillingFamilyTree() {
        FamilyTree familyTree = new FamilyTree();
        Human grandfather1 = new Human("Иван", Gender.MALE, 1940, 01, 01);
        Human grandmother1 = new Human("Ирина", Gender.FEMALE, 1942, 01,01);
        grandfather1.setSpouse(grandmother1);
        grandmother1.setSpouse(grandfather1);
        //
        Human grandfather2 = new Human("Андрей", Gender.MALE, 1950, 02, 01);
        Human grandmother2 = new Human("Анна", Gender.FEMALE, 1950, 02, 02);
        grandfather2.setSpouse(grandfather2);
        grandmother2.setSpouse(grandmother2);
        //
        Human father = new Human("Виктор", Gender.MALE, 1970, 03, 05);
        father.setParents(grandfather1, grandmother1);
        grandfather1.setChild(father);
        grandmother1.setChild(father);
        //
        Human mother = new Human("Вера", Gender.FEMALE, 1973, 10, 10);
        mother.setParents(grandfather2, grandmother2);
        grandfather2.setChild(mother);
        grandmother2.setChild(mother);
        //
        father.setSpouse(mother);
        mother.setSpouse(father);
        //
        Human child1 = new Human("Дима", Gender.MALE, 1999, 03, 07);
        child1.setParents(father, mother);
        Human child2 = new Human("Даша", Gender.FEMALE, 2002, 11, 11);
        child2.setParents(father, mother);
        //??????????????
        father.setChild(child1);
        mother.setChild(child1);
        father.setChild(child2);
        mother.setChild(child2);
        //
        familyTree.addHuman(grandfather1);
        familyTree.addHuman(grandmother1);
        familyTree.addHuman(grandfather2);
        familyTree.addHuman(grandmother2);
        familyTree.addHuman(father);
        familyTree.addHuman(mother);
        familyTree.addHuman(child1);
        familyTree.addHuman(child2);

        return familyTree;
    }
}
