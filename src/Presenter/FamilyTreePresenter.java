package Presenter;

// import FamilyTree.FamilyTree;
import Service.FamilyTreeService;
import View.FamilyTreeView;
import View.Displayable;
import Human.Human;
import Human.Gender;
import java.time.LocalDate;
import java.util.List;

import FamilyTree.FamilyTree;

public class FamilyTreePresenter {
    private FamilyTreeService service;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<Human> familyTree, FamilyTreeView view) {
        this.service = new FamilyTreeService(familyTree);
        this.view = view;
    }

    public FamilyTreePresenter(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    public void setView(FamilyTreeView view) {
        this.view = view;
    }

    public FamilyTreeView getView() {
        return view;
    }

    // public FamilyTreeService getFamilyTreeService() {
    //     return service;
    // }

    public List<Human> getAllElements() {
        return service.getAllElements(); 
    }

    public void onShowFamilyTree() {
        List<Human> familyTree = service.getAllElements();
        view.displayFamilyTree(familyTree);
    }

    //     public void onShowFamilyTree() {
    //     List<Human> familyMembers = service.getFamilyTree();
    //     view.showFamilyTree(familyMembers); // Отображение семейного дерева через view
    // }

    public void onAddHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother) {
        service.addHuman(name, birthDate, deathDate, gender, father, mother);
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Человек успешно добавлен.");
        }
    }

    public Human findByName(String name) {
        return service.findByName(name);
    }

    public void onSortByName() {
        service.sortByName();
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Дерево отсортировано по имени.");
        }
    }

    public void onSortByBirthDate() {
        service.sortByBirthDate();
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Дерево отсортировано по дате рождения.");
        }
    }

    public void onSortByAge() {
        service.sortByAge();
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Дерево отсортировано по возрасту.");
        }
    }

    public void onClearFamilyTree() {
        service.clearFamilyTree();
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Дерево очищено.");
        }
    }

    public void onLoad(String filename) {
        service.load(filename);
        onShowFamilyTree();
        // service = new FamilyTreeService(service.getFamilyTree(), service.getFileHandler());
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Дерево загружено из файла.");
        }
    }

    public void onSave(String filename) {
        service.save(filename);
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Дерево сохранено в файл.");
        }
    }
}