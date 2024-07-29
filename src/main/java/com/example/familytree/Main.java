package com.example.familytree;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        
        familyTree.addPerson("John");
        familyTree.addChild("John", "Michael");
        familyTree.addChild("John", "Sarah");

        familyTree.printFamilyTree();
    }
}
