package View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import Human.Gender;

public class ConsoleInputHandler {
    private Scanner scanner;

    public ConsoleInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Некорректный ввод. Попробуйте снова: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    public LocalDate getDateInput(String prompt) {
        System.out.print(prompt);
        scanner.nextLine();
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            System.out.println("Некорректный формат даты. Попробуйте снова.");
            return getDateInput(prompt);
        }
    }

    public Gender getGenderInput(String prompt) {
        System.out.print(prompt);
        while (true) {
            String input = scanner.next().toUpperCase();
            if (input.equals("MALE")) {
                return Gender.Male;
            } else if (input.equals("FEMALE")) {
                return Gender.Female;
            } else {
                System.out.print("Некорректный ввод. Введите MALE или FEMALE: ");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
