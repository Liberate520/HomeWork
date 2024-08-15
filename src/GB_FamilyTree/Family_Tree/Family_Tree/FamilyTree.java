package GB_FamilyTree.Family_Tree.Family_Tree;

import GB_FamilyTree.Family_Tree.FileManager.FileHandler;
import GB_FamilyTree.Family_Tree.Human.Gender;
import GB_FamilyTree.Family_Tree.Human.Human;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FamilyTree implements Serializable {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.humans.add(human);
    }

    public List<Human> getChildren(Human parent) {
        return parent.getChildren();
    }

    public void addParentChildRelation(Human parent, Human child) {
        parent.addChild(child);
        if (parent.getGender() == Gender.MALE) {
            child.setFather(parent);
        } else {
            child.setMother(parent);
        }
    }

    public List<Human> getAllHumans() {
        return humans;
    }

    public List<Human> getAllChildren(Human parent) {
        return parent.getChildren();
    }

    public void printAllChildren(Human parent) {
        List<Human> children = getAllChildren(parent);
        System.out.println("Дети от " + parent.getName() + "-а:");
        for (Human child : children) {
            System.out.println(child);
        }
    }

    public boolean saveToFile(String filename) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filename);
        return fileHandler.save(this);
    }

    public static FamilyTree loadFromFile(String filename) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filename);
        return (FamilyTree) fileHandler.read();
    }
}