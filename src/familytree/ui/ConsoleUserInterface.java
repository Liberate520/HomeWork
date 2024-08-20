package familytree.ui;

import familytree.model.Person;

import java.util.List;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    @Override
    public String getUserInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }

    @Override
    public void showMenu() {
        System.out.println("Выберите команду: ");
        System.out.println("1 - Добавить члена семьи");
        System.out.println("2 - Найти по имени");
        System.out.println("3 - Добавить родительско-детскую связь");
        System.out.println("4 - Вывести всех членов, отсортированных по фамилии и имени");
        System.out.println("5 - Вывести всех членов, отсортированных по дате рождения");
        System.out.println("6 - Сохранить дерево в файл");
        System.out.println("7 - Загрузить дерево из файла");
        System.out.println("0 - Выйти");
    }
}