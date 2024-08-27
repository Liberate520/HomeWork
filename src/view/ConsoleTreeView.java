package view;

import person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleTreeView implements TreeView {
    private List<Command> commands;

    public ConsoleTreeView() {
        commands = new ArrayList<>();
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayPerson(Person person) {
        System.out.println(person);
    }

    @Override
    public void displayAllPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    @Override
    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (add, find, display, sortName, sortBirth, save, load, addRelation, exit): ");
            String commandStr = scanner.nextLine().toLowerCase();
            boolean executed = false;

            for (Command command : commands) {
                if (command.getName().equalsIgnoreCase(commandStr)) {
                    command.execute();
                    executed = true;
                    break;
                }
            }

            if (!executed) {
                System.out.println("Unknown command. Try again.");
            }

            if (commandStr.equals("exit")) {
                break;
            }
        }
        scanner.close();
    }
}
