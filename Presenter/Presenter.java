package Presenter;

import model.Service.Service;
import model.Writer.FileHandler;
import model.familyTree.FamilyTree;
import model.familyTree.Gender;
import model.familyTree.Human;
import View.View;
import java.time.LocalDate;

public class Presenter {
    private FileHandler fileHandler;
    private Service service;
    private View view;

    public Presenter(View view) {
        this.view = view;
        this.fileHandler = new FileHandler();
        this.service = new Service(fileHandler);
    }

    public void createFamilyLink(String childId, String parentId) {
        service.createFamilyLink(childId, parentId);
    }

    public void getGender() {
        service.getGender();
    }

    public void addMember(String id, String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        service.addMember(id, name, gender, birthDate, deathDate);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void saveFamilyTree(String fileName) {
        service.saveFamilyTree(fileName);
    }

    public void loadFamilyTree(String fileName) {
        service.loadFamilyTree(fileName);
    }

    @SuppressWarnings("unchecked")
    public FamilyTree<Human> getFamilyTree() {
        return service.getFamilyTree();
    }
}