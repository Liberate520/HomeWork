package presenter;

import model.family_tree.FamilyTree;
import model.family_tree.Service;
import model.human.Gender;
import model.human.Human;
import model.writer.FileHandler;
import model.writer.FileManager;
import model.writer.Writer;
import view.View;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Presenter {
    private View view;
    private Service service;
    private FileManager fileManager;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
        fileManager = new FileManager(new FileHandler());
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        service.addHuman(name, gender, birthDate);
        //какой-то ответ
        getFamilyTreeInfo();
    }

    public boolean addParent(String childName, String parentName) {
        return service.addParent(childName, parentName);
    }

    public boolean addParent(int childId, int parentId) {
        return service.addParent(childId, parentId);
    }

    public boolean addChild(String parentName, String childName) {
        return service.addChild(parentName, childName);
    }

    public boolean addChild(int parentId, int childId) {
        return service.addChild(parentId, childId);
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        FamilyTree<Human> familyTree = service.getFamilyTree();
        view.printAnswer(familyTree.toString());
    }

    public boolean setWedding(String name1, String name2) {
        return service.setWedding(name1, name2);
    }

    public boolean setWedding(int id1, int id2) {
        return service.setWedding(id1, id2);
    }

    public boolean setDivorce(String name1, String name2) {
        return service.setDivorce(name1, name2);
    }

    public boolean setDivorce(int id1, int id2) {
        return service.setDivorce(id1, id2);
    }



    public boolean saveToFile(String filename) {
        return fileManager.saveToFile(filename,service.getFamilyTree());
    }

    public boolean loadFromFile(String filePath) {
        fileManager.loadFromFile(filePath);
        service.setFamilyTree(fileManager.loadFromFile(filePath));
        if (service.getFamilyTree().equals(null))
            return false;
        else
            return true;
    }
}