package model.service;

import model.builder.Gender;
import model.builder.Human;
import model.family_tree.FamilyTreeManager;
import model.writer.Writer;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Service {
    private FamilyTreeManager familyTreeManager;
    private Writer fileHandler;
    private String filePath;

    public Service(FamilyTreeManager familyTreeManager, Writer fileHandler, String filePath) {
        this.familyTreeManager = familyTreeManager;
        this.fileHandler = fileHandler;
        this.filePath = filePath;
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        Human human = new Human(name, gender, birthDate, deathDate, father, mother);
        familyTreeManager.addHuman(human);
        return human;
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate) {
        Human human = new Human(name, gender, birthDate);
        familyTreeManager.addHuman(human);
        return human;
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        Human human = new Human(name, gender, birthDate, father, mother);
        familyTreeManager.addHuman(human);
        return human;
    }

    public void setWedding(Human human1, Human human2) {
        familyTreeManager.setWedding(human1, human2);
    }

    public void setDivorce(Human human1, Human human2) {
        familyTreeManager.setDivorce(human1, human2);
    }

    public void addChild(Human parent, Human child) {
        parent.addChild(child);
    }

    public String getFamilyTreeInfo() {
        return familyTreeManager.getFamilyTreeInfo();
    }

    public void saveFamilyTree() throws IOException {
        fileHandler.save((Serializable) familyTreeManager, filePath);
    }

    public FamilyTreeManager loadFamilyTree() throws IOException, ClassNotFoundException {
        return (FamilyTreeManager) fileHandler.read(filePath);
    }
}
