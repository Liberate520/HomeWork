package com.example.familytree;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        familyTree.addPerson("John", new Date(), "Male", null, null);
        familyTree.addChild("John", "Michael", new Date(), "Male");
        familyTree.addChild("John", "Sarah", new Date(), "Female");

        System.out.println(familyTree.getFamilyTree());
    }
}
