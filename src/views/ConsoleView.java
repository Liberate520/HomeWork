package views;

import models.Human;
import models.FamilyTree;

/**
 * Класс ConsoleView реализует интерфейс View и отвечает за отображение информации в консоли.
 */
public class ConsoleView implements View {
    /**
     * Отображает генеалогическое древо в консоли.
     *
     * @param familyTree генеалогическое древо для отображения
     */
    @Override
    public void displayFamilyTree(FamilyTree<Human> familyTree) {
        System.out.println("Родственные связи:");
        for (Human human : familyTree) {
            System.out.println(human);
        }
    }

    /**
     * Отображает генеалогическое древо, отсортированное по имени, в консоли.
     *
     * @param familyTree генеалогическое древо для отображения
     */
    @Override
    public void displaySortedByName(FamilyTree<Human> familyTree) {
        System.out.println("\nСортированный по имени:");
        for (Human human : familyTree) {
            System.out.println(human);
        }
    }

    /**
     * Отображает генеалогическое древо, отсортированное по дате рождения, в консоли.
     *
     * @param familyTree генеалогическое древо для отображения
     */
    @Override
    public void displaySortedByBirthDate(FamilyTree<Human> familyTree) {
        System.out.println("\nСортированный по дате рождения:");
        for (Human human : familyTree) {
            System.out.println(human);
        }
    }

    /**
     * Отображает загруженное генеалогическое древо в консоли.
     *
     * @param familyTree загруженное генеалогическое древо
     */
    @Override
    public void displayLoadedFamilyTree(FamilyTree<Human> familyTree) {
        System.out.println("\nЗагруженные данные:");
        for (Human human : familyTree) {
            System.out.println(human);
        }
    }

    /**
     * Отображает сообщение об ошибке в консоли.
     *
     * @param errorMessage сообщение об ошибке
     */
    @Override
    public void displayError(String errorMessage) {
        System.out.println("Ошибка: " + errorMessage);
    }
}