package familytree.ui;

import familytree.model.Person;

import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class ConsoleUserInterface implements UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final MenuProviderInterface menuProvider;
//    private final Map<String, String> menuItems;

//    public ConsoleUserInterface() {
//        menuItems = new TreeMap<>();
//        initializeMenu();
//    }

    public ConsoleUserInterface(MenuProviderInterface menuProvider) {
        this.menuProvider = menuProvider;
    }

//    private void initializeMenu() {
//        menuItems.put("1", "Добавить члена семьи");
//        menuItems.put("2", "Найти по имени");
//        menuItems.put("3", "Добавить родительско-детскую связь");
//        menuItems.put("4", "Вывести всех членов, отсортированных по фамилии и имени");
//        menuItems.put("5", "Вывести всех членов, отсортированных по дате рождения");
//        menuItems.put("6", "Сохранить дерево в файл");
//        menuItems.put("7", "Загрузить дерево из файла");
//        menuItems.put("0", "Выйти");
//    }

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
    public String promptForInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void showMenu() {
        System.out.println("Выберите команду: ");
        for (Map.Entry<String, String> entry : menuProvider.getMenuItems().entrySet()) {
//        for (Map.Entry<String, String> entry : menuItems.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}