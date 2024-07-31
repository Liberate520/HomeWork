package model.service;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.human.HumanBuilder;
import model.writer.FileHandler;

public class Service {
    private FamilyTree<Human> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
    }

    public Human createHuman(String name, Gender gender, int year, int month, int day) {
        HumanBuilder humanBuilder = new HumanBuilder();
        return humanBuilder.setName(name).setGender(gender).setDateOfBirth(year, month, day).build();
    }

    public void setHumanDateOfDeath(Human human, int year, int month, int day) {
        human.setDateOfDeath(year, month, day);
    }

    public void setHumanParents(Human human, Human father, Human mother) {
        human.setParents(father, mother);
    }

    public void setHumanSpouse(Human human, Human spouse) {
        human.setSpouse(spouse);
    }

    public void addHuman(Human human) {
        this.familyTree.addHuman(human);
    }

    public void sortByName() {
        this.familyTree.sortByName();
    }

    public void sortByAge() {
        this.familyTree.sortByAge();
    }

    public void sortByGender() {
        this.familyTree.sortByGender();
    }

    public String getFamilyTreeInfo() {
        return this.familyTree.toString();
    }

    public void saveFamilyTree() {
        FileHandler handler = new FileHandler();
        handler.write(familyTree, "FamilyTree.bin");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void loadFamilyTree() throws ClassNotFoundException {
        FileHandler handler = new FileHandler();
        this.familyTree = (FamilyTree) handler.read("FamilyTree.bin");
    }
}