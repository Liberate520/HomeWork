package view;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInputHandler {
    private Scanner scanner;

    public UserInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserInput() {
        return scanner.nextLine();
    }

    public String getGenderInput() {
        while (true) {
            String gender = scanner.nextLine().trim().toLowerCase();
            if (gender.equalsIgnoreCase("М")) {
                return "М";
            } else if (gender.equalsIgnoreCase("Ж")) {
                return "Ж";
            } else {
                System.out.println("Некорректно введен пол. Попробуйте ввести еще раз М или Ж.");
            }
        }
    }

    public LocalDate getBirthDateInput() {
        while (true) {
            String inputDate = scanner.nextLine().trim();
            try {
                String[] parts = inputDate.split(" ");
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

    public boolean isValidIdChoice(String idStr, List<Integer> foundHumansId) {
        try {
            int id = Integer.parseInt(idStr);
            return id >= 1 && foundHumansId.contains(id);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}