package Model.Service;

import Model.FamilyTree.FamilyTree;
import Model.FamilyTree.FileHandler.FileHandler;
import Model.FamilyTree.FileHandler.Writable;
import Model.Human.Gender;
import Model.Human.Human;

import java.io.*;
import java.time.LocalDate;

public class Service implements Serializable{
    private FamilyTree<Human> tree;
    private static FileHandler fh = new FileHandler();


    public Service() {
        tree = new FamilyTree<Human>(); {
        }
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        Human human = new Human(name, birthDate, gender);
        tree.addCreatureToFamilyTree(human);
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        Human human = new Human(name, birthDate, deathDate, gender);
        tree.addCreatureToFamilyTree(human);
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void sortByCountOfChildren() {
        tree.sortByCountOfChildren();
    }

    public String printFamilyTree() {
        StringBuilder info = new StringBuilder();
        for (Human human : tree.getFamilyTree()) {
            info.append(human.getInfo());
        }
        return info.toString();
    }

    public String printFamilyTree(FamilyTree<Human> familyTree) {
        StringBuilder info = new StringBuilder();
        for (Human human : tree.getFamilyTree()) {
            info.append(human.getInfo());
        }
        return info.toString();
    }

    public void printMother(Human human) {
        System.out.println(human.getMother().getInfo());
    }

    public void printFather(Human human) {
        System.out.println(human.getFather().getInfo());
    }

    public void getInfo(Human human) {
        System.out.println(human.getInfo());
    }

    public void printChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.getInfo();
        }
    }

    public void printSisters(Human human) {
        for (Human sister : human.getSisters()) {
            sister.getInfo();
        }
    }

    public void printBrothers(Human human) {
        for (Human brother : human.getBrothers()) {
            brother.getInfo();
        }
    }

    public int getFamilyTreeSize() {
        return tree.getFamilyTreeSize();
    }

    public Human getCreatureById(String id) {
        for (Human human : tree) {
            if (human.getId() == Integer.parseInt(id))
                return human;
        }
        return null;
    }

    public void addMother(Human child, Human mother) {
        child.addMother(mother);
    }

    public void addFather(Human child, Human father) {
        child.addFather(father);
    }

    public void removeMother(Human child) {
        child.removeMother();
    }

    public void removeFather(Human child) {
        child.removeMother();
    }

    public void addChild(Human parent, Human child) {
        parent.addChild(child);
    }

    public void removeChild(Human parent, Human child) {
        parent.removeChild(child);
    }

    public void setSpouse(Human human1, Human human2) {
        human1.setSpouse(human2);
    }

    public void setDivorce(Human human) {
        human.setDivorce();
    }

    public void writeObjectToFile() throws IOException {
        fh.writeObjectToFile(this.tree, "src/Model/FamilyTree/FileHandler/text.txt");
    }

    public void recoverObjectFromFile() throws IOException, ClassNotFoundException {
        this.tree = (FamilyTree<Human>) fh.recoverObjectFromFile("src/Model/FamilyTree/FileHandler/text.txt");
    }


}