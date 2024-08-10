package ru.gd.family_tree;

import ru.gd.family_tree.view.ConsoleUI;
import ru.gd.family_tree.view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Writable writable=new FileHandler();
//        writable.save(servis.getFamilyTree(),"familyTree.out");
//
////        FamilyTree familyTreeSave= (FamilyTree) writable.read("familyTree.out");
//        Object familyTreeSave=writable.read("familyTree.out");
//        System.out.println(familyTreeSave);

        View view = new ConsoleUI();
        view.start();

    }
}