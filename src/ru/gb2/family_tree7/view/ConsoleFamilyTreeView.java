package ru.gb2.family_tree7.view;

import ru.gb2.family_tree7.model.human.Gender;
import ru.gb2.family_tree7.model.human.Human;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public abstract class ConsoleFamilyTreeView implements FamilyTreeView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMembers(List<Human> members) {
        System.out.println("Список членов семьи:");
        for (Human member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public Human getNewMember() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите пол (MALE/FEMALE): ");
        String genderInput = scanner.nextLine();
        Gender gender = Gender.valueOf(genderInput.toUpperCase());

        String role = selectRole();


//        int birthDate = scanner.nextInt();
//        scanner.nextLine(); // Удалите новую строку после ввода числа
        Scanner scanner = new Scanner(System.in);

        LocalDate birthDate = null; // Создаем переменную для хранения даты рождения

        while (birthDate == null) { // Цикл для повторного ввода, если дата будет некорректной
            System.out.println("Введите дату рождения (ГГГГ-ММ-ДД):");
            String dateStr = scanner.nextLine();

            try {
                birthDate = LocalDate.parse(dateStr); // Преобразуем строку в LocalDate
            } catch (DateTimeParseException e) {
                System.out.println("Некорректная дата. Пожалуйста, введите в формате ГГГГ-ММ-ДД.");
            }
        }

        return new Human(name, gender, birthDate, role);
    }

    private String selectRole() {
        System.out.println("Выберите роль:");
        System.out.println("1 - Мама");
        System.out.println("2 - Папа");
        System.out.println("3 - Ребенок");
        System.out.print("Ваш выбор: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Удалите новую строку после ввода числа

        switch (choice) {
            case 1:
                return "Мама";
            case 2:
                return "Папа";
            case 3:
                return "Ребенок";
            default:
                System.out.println("Некорректный выбор, роль будет установлена как 'Ребенок'.");
                return "Ребенок"; // Значение по умолчанию
        }
    }
}
