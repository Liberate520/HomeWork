package Presenter;

import FamilyTree.FamilyTree;
import View.FamilyTreeView;
import View.Displayable;
import View.FamilyTreeViewer;
import Human.Human;
import Human.Gender;
import Writer.Writer;
import java.time.LocalDate;

public class FamilyTreePresenter {
    private FamilyTree<Human> familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<Human> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void setView(FamilyTreeView view) {
        this.view = view;
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public FamilyTreeView getView() {
        return view;
    }

    public void onAddHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother) {
        int id = familyTree.getNextId();
        Human newHuman = new Human(id, name, birthDate, deathDate, gender, father, mother);
        familyTree.addElement(newHuman);
        if (father != null) father.addChild(newHuman);
        if (mother != null) mother.addChild(newHuman);
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Человек успешно добавлен.");
        }
    }

    public Human findByName(String name) {
        return familyTree.findByName(name);
    }

    public void onShowFamilyTree() {
        if (view instanceof FamilyTreeViewer) {
            ((FamilyTreeViewer) view).showFamilyTree(familyTree.getAllElements());
        }
    }

    public void onSortByName() {
        familyTree.sortByName();
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Дерево отсортировано по имени.");
        }
    }

    public void onSortByBirthDate() {
        familyTree.sortByBirthDate();
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Дерево отсортировано по дате рождения.");
        }
    }

    public void onSortByAge() {
        familyTree.sortByAge();
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Дерево отсортировано по возрасту.");
        }
    }

    public void onClearFamilyTree() {
        familyTree.clear();
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Дерево очищено.");
        }
    }

    public void onLoad(Writer fileHandler, String filename) {
        if (filename == null || filename.isEmpty()) {
            if (view instanceof Displayable) {
                ((Displayable) view).showError("Путь к файлу не может быть пустым.");
            }
            return;
        }
    
        fileHandler.setPath(filename);
        FamilyTree<Human> loadedTree = (FamilyTree<Human>) fileHandler.read();
        if (loadedTree != null) {
            familyTree = loadedTree;
            if (view instanceof Displayable) {
                ((Displayable) view).displayMessage("Дерево загружено из файла.");
            }
        } else {
            if (view instanceof Displayable) {
                ((Displayable) view).showError("Ошибка загрузки дерева из файла.");
            }
        }
    }

    public void onSave(Writer fileHandler, String filename) {
        fileHandler.setPath(filename);
        fileHandler.save(familyTree);
        if (view instanceof Displayable) {
            ((Displayable) view).displayMessage("Дерево сохранено в файл.");
        }
    }
}

