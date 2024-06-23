package project.View;

import java.util.HashMap;
import java.util.Map;

import project.Command.Command;

public class Menu {
    private Map<Integer, Command> commands;

    public Menu() {
        this.commands = new HashMap<>();
    }

    public void addCommand(int option, Command command) {
        commands.put(option, command);
    }

    public void display() {
        System.out.println("Меню:");
        System.out.println("1. Добавть в древо");
        System.out.println("2. Сохранить семейное дерево");
        System.out.println("3. Загрузить семейное древо");
        System.out.println("4. Отображение детей участника древа");
        System.out.println("5. Сортировать по имени");
        System.out.println("6. Сортировать по дате рождения");
        System.out.println("7. Выход");
        System.out.print("Введите цифру, соответствующую вашему выбору: ");
    }

    public void executeCommand(int choice) {
        Command command = commands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
        }
    }
}

