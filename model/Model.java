package model;

import model.familyTree.FamilyTree;
import model.familyTree.Gender;
import model.familyTree.Human;
import model.Service.Service;

import java.time.LocalDate;

public class Model {
    private Service service;

    public Model(Service service) {
        this.service = service;
    }

    public void addMember(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        service.addMember(name, gender, birthDate, deathDate);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public FamilyTree<Human> getFamilyTree() {
        return service.getFamilyTree();
    }

    public void saveFamilyTree(String fileName) {
        service.saveFamilyTree(fileName);
    }

    public void loadFamilyTree(String fileName) {
        service.loadFamilyTree(fileName);
    }
}