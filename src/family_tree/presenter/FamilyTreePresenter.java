package family_tree.presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import family_tree.model.FamilyTreeModel;
import family_tree.model.Human;
import family_tree.view.ConsoleFamilyTreeView;

import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeModel model;
    private ConsoleFamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeModel model, ConsoleFamilyTreeView view) {
        this.model = model;
        this.view = view;
    }

    public void onSortByName() {
        List<Human> sortedTree = model.getSortedTree();
        view.displaySortedTree(sortedTree);
    }

    public void onSortByBirthDate() {
        List<Human> sortedTree = model.getSortedTree();
        sortedTree.sort((h1, h2) -> {
            LocalDate birthDate1 = LocalDate.parse(h1.getBirthDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalDate birthDate2 = LocalDate.parse(h2.getBirthDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return birthDate1.getYear() - birthDate2.getYear();
        });
        view.displaySortedTree(sortedTree);
    }


    public void onDisplayUnsortedTree() {
        List<Human> unsortedTree = model.getUnsortedTree();
        view.displayUnsortedTree(unsortedTree);
    }


    public void onSearch(String name) {
        Human foundBeing = model.findBeing(name);
        if (foundBeing != null) {
            view.displayHumanDetails(foundBeing);
        } else {
            view.displayErrorMessage("Человек с именем " + name + " не найден!");
        }
    }
}
