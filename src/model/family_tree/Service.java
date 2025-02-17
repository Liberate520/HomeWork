package model.family_tree;

import model.human.Human;
import model.human.Gender;
import model.human.HumanBuilder;
import model.writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;

    public Service() {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        Human human = humanBuilder.setName(name).setGender(gender).setBirthDate(birthDate).build();
        familyTree.add(human);
    }

    public boolean setWedding(String name1, String name2) {
        return familyTree.setWedding(familyTree.findByName(name1), familyTree.findByName(name2));
    }

    public boolean setWedding(int id1, int id2) {
        return familyTree.setWedding(familyTree.findById(id1), familyTree.findById(id2));
    }

    public boolean setDivorce(String name1, String name2) {
        return familyTree.setDivorce(familyTree.findByName(name1), familyTree.findByName(name2));
    }

    public boolean setDivorce(int id1, int id2) {
        return familyTree.setDivorce(familyTree.findById(id1), familyTree.findById(id2));
    }

    public boolean addChild(String human, String child) {
        return familyTree.findByName(human).addChild(familyTree.findByName(child));
    }

    public boolean addChild(int idHuman, int idChild) {
        return familyTree.findById(idHuman).addChild(familyTree.findById(idChild));
    }

    public boolean addParent(String child, String parent) {
        return familyTree.findByName(child).addParent(familyTree.findByName(parent));
    }

    public boolean addParent(int child, int parent) {
        return familyTree.findById(child).addParent(familyTree.findById(parent));
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }
}
