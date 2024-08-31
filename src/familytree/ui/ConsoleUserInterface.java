package familytree.ui;

import familytree.model.Person;

import java.util.List;
import java.util.Scanner;
import java.util.Map;


public class ConsoleUserInterface implements UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final MenuProviderInterface menuProvider;

    public ConsoleUserInterface(MenuProviderInterface menuProvider) {
        this.menuProvider = menuProvider;
    }

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
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}