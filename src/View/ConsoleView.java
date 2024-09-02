package View;

import Model.Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ConsoleView implements FamilyTreeView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить человека");
        System.out.println("2. Установить родителей");
        System.out.println("3. Показать всех людей");
        System.out.println("4. Найти по имени");
        System.out.println("5. Показать детей");
        System.out.println("6. Показать родителей");
        System.out.println("7. Сохранить дерево");
        System.out.println("8. Загрузить дерево");
        System.out.println("9. Редактирование записи");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
    }

    @Override
    public void displayPeople(List<Person> people) {
        if (people.isEmpty()) {
            System.out.println("В дереве пока нет членов семьи.");
        } else {
            System.out.println("Члены семьи:");
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayPerson(Person person) {
        System.out.println(person);
    }

    public Scanner getScanner() {
        return scanner;
    }
    public LocalDate getDateInput(String prompt) {
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt);
            String dateStr = scanner.nextLine();
            if (dateStr.isEmpty()) {
                break;
            }
            try {
                date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат даты. Пожалуйста, используйте формат ГГГГ-ММ-ДД.");
            }
        }
        return date;
    }

    public Person.Gender getGenderInput(String prompt) {
        Person.Gender gender = null;
        while (gender == null) {
            System.out.print(prompt);
            String genderStr = scanner.nextLine();
            if (genderStr.isEmpty()) {
                break;
            }
            try {
                gender = Person.Gender.valueOf(genderStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Неправильный формат гендера. Пожалуйста, используйте МУЖЧИНА или ЖЕНЩИНА.");
            }
        }
        return gender;
    }
}
