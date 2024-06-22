package view;

import view.commands.*;

import java.util.HashMap;
import java.util.Map;
import model.service.Service;


public class MainMenu {
    private Map<String, Command> commands;
    private ConsoleUI consoleUI;
    private Service service;

    public MainMenu(ConsoleUI consoleUI, Service service) {
        this.consoleUI = consoleUI;
        this.service = service;

        this.commands = new HashMap<>();
        commands.put("1", new AddMember(consoleUI));
        commands.put("2", new AddChild(consoleUI, service));
        commands.put("3", new SetWedding(consoleUI));
        commands.put("4", new SetDivorce(consoleUI));
        commands.put("5", new LoadTree(consoleUI));
        commands.put("6", new SaveTree(consoleUI));
        commands.put("7", new GetTreeInfo(consoleUI));
        commands.put("8", new SortByBirthDate(consoleUI));
        commands.put("9", new SortByName(consoleUI));
        commands.put("0", new Finish(consoleUI));
    }

    public String printMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("Меню:\n");
        menu.append("1. Добавить члена семьи\n");
        menu.append("2. Добавить ребёнка\n");
        menu.append("3. Установить брак\n");
        menu.append("4. Оформить развод\n");
        menu.append("5. Загрузить дерево\n");
        menu.append("6. Сохранить дерево\n");
        menu.append("7. Показать информацию о дереве\n");
        menu.append("8. Отсортировать по дате рождения\n");
        menu.append("9. Отсортировать по имени\n");
        menu.append("0. Выход\n");
        return menu.toString();
    }

    public void execute(String choice) {
        Command command = commands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Неверная команда, попробуйте снова.");
        }
    }
}
