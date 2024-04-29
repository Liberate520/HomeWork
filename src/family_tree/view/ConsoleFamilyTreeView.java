package family_tree.view;

import family_tree.model.Human;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    @Override
    public void displaySortedTree(List<Human> sortedTree) {
        System.out.println("Отсортированный список по алфавиту:");
        for (Human person : sortedTree) {
            System.out.println(person.getName() + " - " + person.getBirthDate());
        }
    }

    @Override
    public void displayErrorMessage(String message) {
        System.err.println("Ошибка: " + message);
    }

    @Override
    public void displayHumanDetails(Human human) {
        System.out.println("Имя: " + human.getName());
        System.out.println("Пол: " + human.getGender());
        System.out.println("Дата рождения: " + human.getBirthDate());
        if (human.getDeathDate() != null) {
            System.out.println("Дата смерти: " + human.getDeathDate());
        }
        System.out.println("Родители: " + getHumanNames(human.getParents()));
        System.out.println("Дети: " + getHumanNames(human.getChildren()));
    }

    @Override
    public void displayUnsortedTree(List<Human> unsortedTree) {
        System.out.println("Список членов семьи (неотсортированный):");
        Set<String> printedNames = new HashSet<>(); // Хранит имена уже выведенных людей
        for (Human person : unsortedTree) {
            displayPersonWithIndent(person, 0, printedNames);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displaySaveSuccessMessage(String message) {
        System.out.println("Успешно: " + message);
    }

    @Override
    public void displaySaveErrorMessage(String message) {
        System.err.println("Ошибка при сохранении: " + message);
    }

    @Override
    public void displayLoadSuccessMessage(String message) {
        System.out.println("Успешно: " + message);
    }

    @Override
    public void displayLoadErrorMessage(String message) {
        System.err.println("Ошибка при загрузке: " + message);
    }

    private void displayPersonWithIndent(Human person, int level, Set<String> printedNames) {
        if (!printedNames.contains(person.getName())) { // Проверяем, был ли человек уже выведен
            StringBuilder indent = new StringBuilder();
            for (int i = 0; i < level; i++) {
                indent.append("  "); // Добавляем отступ для каждого уровня
            }
            System.out.println(indent.toString() + person.getName() + " - " + person.getBirthDate());
            printedNames.add(person.getName()); // Добавляем имя человека в множество выведенных
        }
        for (Human child : person.getChildren()) {
            displayPersonWithIndent(child, level + 1, printedNames); // Увеличиваем уровень для детей
        }
    }

    private String getHumanNames(List<Human> humans) {
        StringBuilder names = new StringBuilder();
        for (Human human : humans) {
            names.append(human.getName()).append(", ");
        }
        // Убираем последнюю запятую и пробел
        if (names.length() > 0) {
            names.setLength(names.length() - 2);
        }
        return names.toString();
    }
}
