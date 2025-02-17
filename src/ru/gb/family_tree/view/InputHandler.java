package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public Gender getGenderInput() {
        while (true) {
            String genderStr = scanner.nextLine().trim();
            if (genderStr.equalsIgnoreCase("м")) {
                return Gender.Male;
            } else if (genderStr.equalsIgnoreCase("ж")) {
                return Gender.Female;
            } else {
                System.out.println("Введен неправильный пол, попробуйте заново (м/ж):");
            }
        }
    }

    public LocalDate getBirthDateInput() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                String[] parts = input.split(" ");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                LocalDate birthDate = LocalDate.of(year, month, day);
                if (birthDate.isAfter(LocalDate.now())) {
                    System.out.println("Дата рождения не может быть больше текущей даты. Пожалуйста, введите корректную дату:");
                } else {
                    return birthDate;
                }
            } catch (DateTimeException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Неверный формат даты рождения. Пожалуйста, введите дату в формате ДД ММ ГГГГ:");
            }
        }
    }

    public boolean isValidMenuChoice(String choiceStr, int menuSize) {
        try {
            int choice = Integer.parseInt(choiceStr);
            return choice >= 1 && choice <= menuSize;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidIdChoice(String idStr, List<Long> foundHumansId) {
        try {
            int id = Integer.parseInt(idStr);
            return id >= 1 && foundHumansId.contains(id);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
