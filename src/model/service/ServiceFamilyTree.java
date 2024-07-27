package model.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import model.builder.Gender;
import model.builder.Human;
import model.family_tree.FamilyTree;
import model.writer.FileHandler;

public class ServiceFamilyTree {
    private FamilyTree<Human> familyTree;
    private ServiceValidate validator;
    private FileHandler fileHandler;

    public ServiceFamilyTree() {
        this.familyTree = new FamilyTree<>();
        this.validator = new ServiceValidate();
        this.fileHandler = new FileHandler();
    }

    public int getFamilyTreeSize() {
        return familyTree.getHumanListSize();
    }

    public void addHumanToFamilyTree(Human human) {
        familyTree.add(human);
    }

    public boolean validateName(String name) {
        return validator.validateName(name);
    }

    public String getNameErrorMessage() {
        return validator.getNameErrorMessage();
    }

    public boolean validateBirthDate(String birthDateStr) {
        return validator.validateBirthDate(birthDateStr);
    }

    public LocalDate getValidatedBirthDate() {
        return validator.getValidatedBirthDate();
    }

    public String getBirthDateErrorMessage() {
        return validator.getBirthDateErrorMessage();
    }

    public boolean validateGender(int genderOption) {
        return validator.validateGender(genderOption);
    }

    public Gender getValidatedGender(int genderOption) {
        return validator.getValidatedGender(genderOption);
    }

    public boolean validateDeathDate(String deathDateStr) {
        return validator.validateDeathDate(deathDateStr);
    }

    public LocalDate getValidatedDeathDate() {
        return validator.getValidatedDeathDate();
    }

    public String getDeathDateErrorMessage() {
        return validator.getDeathDateErrorMessage();
    }

    public boolean validateNumericChoice(String choice, int min, int max) {
        return validator.validateNumericChoice(choice, min, max);
    }

    public String getNumericChoiceErrorMessage() {
        return validator.getNumericChoiceErrorMessage();
    }

    public List<Human> getAllHumans() {
        return familyTree.getHumanList();
    }

    public List<Human> getPotentialSpouses(Human person) {
        return familyTree.getPotentialSpouses(person);
    }

    public void setWedding(Human person, Human spouse) {
        familyTree.setWedding(person, spouse);
    }

    public void addParent(Human person, Human parent) {
        familyTree.addParent(person, parent);
    }

    public List<Human> getPotentialParentsByGender(Gender gender, Human human) {
        return familyTree.getPotentialParentsByGender(gender, human);
    }

    public List<Human> getPotentialChildren(Human human) {
        return familyTree.getPotentialChildren(human);
    }

    public void addChild(Human parent, Human child) {
        familyTree.addChild(parent, child);
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    public boolean saveFamilyTree() {
        try {
            fileHandler.save(familyTree);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public FamilyTree<Human> readFamilyTree() throws IOException, ClassNotFoundException {
        try {
            return (FamilyTree<Human>) fileHandler.deserialize();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }
}