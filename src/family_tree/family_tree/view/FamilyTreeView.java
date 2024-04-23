package family_tree.family_tree.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.human.HumanComparatorByBirthDate;
import family_tree.human.HumanComparatorByName;

public class FamilyTreeView {
    private Scanner scanner;

    public FamilyTreeView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Вывести список членов семьи Карлеоне");
        System.out.println("2. Добавить нового члена семьи");
        System.out.println("3. Отсортировать по имени");
        System.out.println("4. Отсортировать по дате рождения");
        System.out.println("5. Завершить программу");
    }

    public int getUserChoice() {
        System.out.print("Выберите действие: ");
        return scanner.nextInt();
    }

    public String promptForName() {
        System.out.print("Введите имя нового члена семьи: ");
        scanner.nextLine(); // Сбросить буфер после nextInt()
        return scanner.nextLine();
    }

    public LocalDate promptForDateOfBirth() {
        System.out.print("Введите дату рождения нового члена семьи (ГГГГ-ММ-ДД): ");
        String dobString = scanner.nextLine();
        return LocalDate.parse(dobString);
    }

    public Gender promptForGender() {
        System.out.print("Введите пол нового члена семьи (Male/Female): ");
        String genderString = scanner.nextLine();
        return Gender.valueOf(genderString);
    }

    public void displayErrorMessage(String message) {
        System.out.println("Ошибка: " + message);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayFamilyMembers(List<Human> familyMembers) {
        System.out.println("Члены семьи Карлеоне:");
        for (Human member : familyMembers) {
            System.out.println("Имя: " + member.getName() + ", Дата рождения: " + member.getDateOfBirth() + ", Дата смерти: " + member.getDateOfDeath() + ", Пол: " + member.getGender());
            if (member.getMother() != null) {
                System.out.println("Мать: " + member.getMother().getName());
            }
            if (member.getFather() != null) {
                System.out.println("Отец: " + member.getFather().getName());
            }
            System.out.println();
        }
    }

    public void displaySortedFamilyMembers(List<Human> familyMembers) {
        System.out.println("Отсортированный список:");
        for (Human member : familyMembers) {
            System.out.println("Имя: " + member.getName() + ", Дата рождения: " + member.getDateOfBirth() + ", Дата смерти: " + member.getDateOfDeath() + ", Пол: " + member.getGender());
        }
    }

    public void closeScanner() {
        scanner.close();
    }

    public void runApplicationLoop() {
        int choice = 0;
        while (choice != 5) {
            displayMenu();
            choice = getUserChoice();
            switch (choice) {
                case 1:
                    displayFamilyMembers();
                    break;
                case 2:
                    addNewFamilyMember();
                    break;
                case 3:
                    sortByName();
                    break;
                case 4:
                    sortByBirthDate();
                    break;
                case 5:
                    closeScanner();
                    System.out.println("Программа завершена.");
                    break;
                default:
                    displayErrorMessage("Некорректный выбор. Пожалуйста, выберите действие из списка.");
            }
        }
    }
}
