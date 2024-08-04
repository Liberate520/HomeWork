package com.example.familytree.main;

import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        familyTree.addPerson("John", new Date(), "Male", null, null);
        familyTree.addChild("John", "Michael", new Date(), "Male");
        familyTree.addChild("John", "Sarah", new Date(), "Female");

        try {
            familyTree.saveToFile("familyTree.dat");
            System.out.println("Family tree saved to file.");

            FamilyTree loadedFamilyTree = FamilyTree.loadFromFile("familyTree.dat");
            System.out.println("Family tree loaded from file.");
            System.out.println(loadedFamilyTree.getFamilyTree());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
