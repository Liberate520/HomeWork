package model.service;

import model.builder.HumanBuilder;
import model.familyTreeSrc.FamilyTree;
import model.person.Gender;
import model.person.Human;
import model.writer.FileHandler;
import model.writer.Writer;

import java.time.LocalDate;

public class Service {
    private HumanBuilder humanBuilder;
    private FamilyTree<Human> familyTree;
    private Writer fileHandler;

    public Service() {
        humanBuilder = new HumanBuilder();
        familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth) {
        Human human = humanBuilder.build(name, gender, dateOfBirth);
        familyTree.addHuman(human);
    }

    public void addChildToParent(long idParent, long idChild) {
        Human parent = familyTree.getById(idParent);
        Human child = familyTree.getById(idChild);
        parent.addChild(child);
    }

    public void setMother(long idChild, long idMother) {
        Human mother = familyTree.getById(idMother);
        Human child = familyTree.getById(idChild);
        child.setMother(mother);
    }

    public void setFather(long idChild, long idFather) {
        Human father = familyTree.getById(idFather);
        Human child = familyTree.getById(idChild);
        child.setFather(father);
    }

    public void setDateOfDeath(long idHuman, LocalDate dateOfDeath) {
        Human human = familyTree.getById(idHuman);
        human.setDeathDate(dateOfDeath);
    }

    public LocalDate getBirthDate(long idHuman) {
        return familyTree.getById(idHuman).getBirthDate();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByBirthDate();
    }

    public void sortByChildrenQuantity() {
        familyTree.sortByChildrenQuantity();
    }

    public void sortById() {
        familyTree.sortById();
    }

    public void setWedding(long humanId1, long humanId2) {
        familyTree.setWedding(humanId1, humanId2);
    }

    public void setDivorce(long humanId1, long humanId2) {
        familyTree.setDivorce(humanId1, humanId2);
    }

    public String getHumansListInfo() {
        String result = "Информация о древе:\n";
        return result + familyTree.getInfo();
    }

    public Human getHumanById(long idHuman) {
        return familyTree.getById(idHuman);
    }

    public void saveFile() {
        fileHandler.save(familyTree);
    }

    public Object readFile() {
        return familyTree = (FamilyTree<Human>) fileHandler.read();
    }

    public void setCustomPath(String path) {
        fileHandler.setPath(path);
    }

    public String getPath() {
        return fileHandler.getPath();
    }
}
