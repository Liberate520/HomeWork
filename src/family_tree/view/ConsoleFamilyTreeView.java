package family_tree.view;

import family_tree.model.Human;

import java.util.List;

public class ConsoleFamilyTreeView {
    public void displaySortedTree(List<Human> sortedTree) {
        System.out.println("Отсортированный список по алфавиту:");
        for (Human person : sortedTree) {
            System.out.println(person.getName() + " - " + person.getBirthDate());
        }
    }

    public void displayErrorMessage(String message) {
        System.err.println("Ошибка: " + message);
    }

    public void displayHumanDetails(Human human) {
        System.out.println("Имя: " + human.getName());
        System.out.println("Пол: " + human.getGender());
        System.out.println("Дата рождения: " + human.getBirthDate());
        System.out.println("Дата смерти: " + (human.getDeathDate() != null ? human.getDeathDate() : "Жив"));
        System.out.println("Родители: " + human.getParents());
        System.out.println("Дети: " + human.getChildren());
    }
}
