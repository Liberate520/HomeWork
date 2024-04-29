package family_tree.presenter;

import family_tree.model.FamilyTreeModel;
import family_tree.model.Human;

import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeModel model;

    public FamilyTreePresenter(FamilyTreeModel model) {
        this.model = model;
    }

    public void onInit() {
        List<Human> sortedTree = model.getSortedTree();
        displaySortedTree(sortedTree);
    }

    public void onSearch(String name) {
        Human foundBeing = model.findBeing(name);
        if (foundBeing != null) {
            displayHumanDetails(foundBeing);
        } else {
            displayErrorMessage("Человек с именем " + name + " не найден!");
        }
    }

    public void onSortByBirthDate() {
        model.sortByBirthDate();
        List<Human> sortedTree = model.getSortedTree();
        displaySortedTree(sortedTree);
    }

    private void displaySortedTree(List<Human> sortedTree) {
        System.out.println("Отсортированный список по алфавиту:");
        for (Human person : sortedTree) {
            System.out.println(person.getName() + " - " + person.getBirthDate());
        }
    }

    private void displayErrorMessage(String message) {
        System.err.println("Ошибка: " + message);
    }

    private void displayHumanDetails(Human human) {
        System.out.println("Имя: " + human.getName());
        System.out.println("Пол: " + human.getGender());
        System.out.println("Дата рождения: " + human.getBirthDate());
        System.out.println("Дата смерти: " + (human.getDeathDate() != null ? human.getDeathDate() : "Жив"));
        System.out.println("Родители: " + human.getParents());
        System.out.println("Дети: " + human.getChildren());
    }
}
