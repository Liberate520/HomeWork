package views;

import models.Human;
import models.FamilyTree;
import models.Gender;
import java.util.Scanner;

/**
 * Класс ConsoleView реализует интерфейс View и отвечает за отображение информации в консоли.
 */
public class ConsoleView implements View {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Отображает генеалогическое древо в консоли в указанном порядке сортировки.
     *
     * @param familyTree генеалогическое древо для отображения
     * @param sortOrder  порядок сортировки для отображения
     */
    @Override
    public void displayFamilyTree(FamilyTree<Human> familyTree, SortOrder sortOrder) {
        switch (sortOrder) {
            case NAME:
                System.out.println("\nСортированный по имени:");
                break;
            case BIRTH_DATE:
                System.out.println("\nСортированный по дате рождения:");
                break;
            case UNSORTED:
                System.out.println("Родственные связи:");
                break;
            case LOADED:
                System.out.println("\nЗагруженные данные:");
                break;
        }
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

    /**
     * Запрашивает у пользователя информацию о новом человеке и возвращает его.
     *
     * @return новый человек
     */
    @Override
    public Human addHuman() {
        System.out.print("Введите имя нового человека: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату рождения нового человека (дд.мм.гггг): ");
        String birthDate = scanner.nextLine();

        System.out.print("Введите дату смерти нового человека (дд.мм.гггг): ");
        String deathDate = scanner.nextLine();

        System.out.print("Введите пол нового человека (M/F): ");
        String genderInput = scanner.nextLine();
        Gender gender = genderInput.equalsIgnoreCase("M") ? Gender.MALE : Gender.FEMALE;

        return new Human(name, birthDate, deathDate, gender);
    }
}
