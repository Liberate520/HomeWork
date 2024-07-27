package presenter;

import model.builder.Gender;
import model.builder.Human;
import model.family_tree.FamilyTree;
import model.service.ServiceBuildHuman;
import model.service.ServiceFamilyTree;

import java.io.IOException;
import java.time.LocalDate;

import java.util.List;

public class Presenter {
    private final ServiceFamilyTree serviceFamilyTree;
    private final ServiceBuildHuman serviceBuildHuman;

    public Presenter() {
        this.serviceFamilyTree = new ServiceFamilyTree();
        this.serviceBuildHuman = new ServiceBuildHuman();
    }

    public int getFamilyTreeSize() {
        return serviceFamilyTree.getFamilyTreeSize();
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        return serviceBuildHuman.createHuman(name, gender, birthDate, deathDate);
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate) {
        return serviceBuildHuman.createHuman(name, gender, birthDate);
    }

    public void addHumanToFamilyTree(Human human) throws IOException {
        serviceFamilyTree.addHumanToFamilyTree(human);
    }

    public boolean validateName(String name) {
        return serviceFamilyTree.validateName(name);
    }

    public String getNameErrorMessage() {
        return serviceFamilyTree.getNameErrorMessage();
    }

    public boolean validateBirthDate(String birthDateStr) {
        return serviceFamilyTree.validateBirthDate(birthDateStr);
    }

    public LocalDate getValidatedBirthDate() {
        return serviceFamilyTree.getValidatedBirthDate();
    }

    public String getBirthDateErrorMessage() {
        return serviceFamilyTree.getBirthDateErrorMessage();
    }

    public boolean validateGender(int genderOption) {
        return serviceFamilyTree.validateGender(genderOption);
    }

    public Gender getValidatedGender(int genderOption) {
        return serviceFamilyTree.getValidatedGender(genderOption);
    }

    public boolean validateDeathDate(String deathDateStr) {
        return serviceFamilyTree.validateDeathDate(deathDateStr);
    }

    public LocalDate getValidatedDeathDate() {
        return serviceFamilyTree.getValidatedDeathDate();
    }

    public String getDeathDateErrorMessage() {
        return serviceFamilyTree.getDeathDateErrorMessage();
    }

    public boolean validateNumericChoice(String choice, int min, int max) {
        return serviceFamilyTree.validateNumericChoice(choice, min, max);
    }

    public String getNumericChoiceErrorMessage() {
        return serviceFamilyTree.getNumericChoiceErrorMessage();
    }

    public List<Human> getAllHumans() {
        return serviceFamilyTree.getAllHumans();
    }

    public List<Human> getPotentialSpouses(Human person) {
        return serviceFamilyTree.getPotentialSpouses(person);
    }

    public void setWedding(Human person, Human spouse) {
        serviceFamilyTree.setWedding(person, spouse);
    }

    public void addParent(Human person, Human parent) {
        serviceFamilyTree.addParent(person, parent);
    }

    public List<Human> getPotentialParentsByGender(Gender gender, Human human) {
        return serviceFamilyTree.getPotentialParentsByGender(gender, human);
    }

    public List<Human> getPotentialChildren(Human human) {
        return serviceFamilyTree.getPotentialChildren(human);
    }

    public void addChild(Human parent, Human child) {
        serviceFamilyTree.addChild(parent, child);
    }

    public boolean saveFamilyTree() {
        return serviceFamilyTree.saveFamilyTree();
    }

    public FamilyTree<Human> readFamilyTree() throws IOException, ClassNotFoundException {
        return serviceFamilyTree.readFamilyTree();
    }

    public ServiceFamilyTree getServiceFamilyTree() {
        return serviceFamilyTree;
    }
}


