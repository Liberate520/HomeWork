package Presenter;

import FamilyTree.FamilyTree;
import Human.*;
import Service.FamilyTreeService;
import View.FamilyTreeView;
import Writer.Writer;


import java.time.LocalDate;

public class FamilyTreePresenter {
    private final FamilyTreeService familyTreeService;
    public FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<Human> familyTree, FamilyTreeView view) {
        this.familyTreeService = new FamilyTreeService(familyTree);
        this.view = view;
    }

    public void setView(FamilyTreeView view) {
        this.view = view;
    }

    public FamilyTreeView getView() {  
        return this.view;
    }

    public void onAddHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother) {
        familyTreeService.addHuman(name, birthDate, deathDate, gender, father, mother);
    }

    public void onSortByName() {
        familyTreeService.sortByName();
        view.showFamilyTree(familyTreeService.getFamilyTree().getAllElements());
    }

    public void onSortByBirthDate() {
        familyTreeService.sortByBirthDate();
        view.showFamilyTree(familyTreeService.getFamilyTree().getAllElements());
    }

    public void onSortByAge() {
        familyTreeService.sortByAge();
        view.showFamilyTree(familyTreeService.getFamilyTree().getAllElements());
    }

    public void onSave(Writer fileHandler, String filename) {
        familyTreeService.save(fileHandler, filename);
        view.displayMessage("Дерево сохранено в файл: " + filename);
    }

    public void onLoad(Writer fileHandler) {
        familyTreeService.load(fileHandler);
        view.displayMessage("Дерево загружено из файла.");
        view.showFamilyTree(familyTreeService.getFamilyTree().getAllElements());
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTreeService.getFamilyTree();
    }

    public Human findByName(String name) {
        return familyTreeService.findByName(name);
    }
}
