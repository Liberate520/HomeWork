package View;

import Model.Person;

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
}
