package presenter;

import model.builder.Gender;
import model.builder.Human;
import model.family_tree.FamilyTree;
import model.family_tree.FamilyTreeManagerImpl;
import model.service.Service;
import model.writer.FileHandler;
import view.FamilyTreeView;

import java.io.IOException;
import java.time.LocalDate;

public class FamilyTreePresenter {
    private FamilyTreeView view;
    private Service service;

    public FamilyTreePresenter(FamilyTreeView view) {
        this.view = view;
        this.service = new Service(new FamilyTreeManagerImpl(new FamilyTree<>()), new FileHandler(), "src/model/writer/tree.txt");
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate) {
        return service.createHuman(name, gender, birthDate);
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        return service.createHuman(name, gender, birthDate, deathDate, father, mother);
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        return service.createHuman(name, gender, birthDate, father, mother);
    }

    public void setWedding(Human human1, Human human2) {
        service.setWedding(human1, human2);
    }

    public void addChild(Human parent, Human child) {
        service.addChild(parent, child);
    }

    public String getFamilyTreeInfo() {
        return service.getFamilyTreeInfo();
    }

    public void saveFamilyTree() {
        try {
            service.saveFamilyTree();
        } catch (IOException e) {
            view.showError("Error saving family tree: " + e.getMessage());
        }
    }

    public void loadFamilyTree() {
        try {
            service.loadFamilyTree();
            view.displayFamilyTreeInfo(service.getFamilyTreeInfo());
        } catch (IOException | ClassNotFoundException e) {
            view.showError("Error loading family tree: " + e.getMessage());
        }
    }

    public void displayFamilyTree() {
        view.displayFamilyTreeInfo(service.getFamilyTreeInfo());
    }
}
