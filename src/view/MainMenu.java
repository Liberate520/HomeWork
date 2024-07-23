package view;

import java.util.HashMap;
import java.util.Map;

public class MainMenu {

    private ConsoleUI ui;
    private Map<Integer, Runnable> commands;

    public MainMenu(ConsoleUI ui) {
        this.ui = ui;
        commands = new HashMap<>();
        commands.put(1, ui::displayHumanList);
        commands.put(2, ui::addHuman);
        commands.put(3, ui::sortByName);
        commands.put(4, ui::sortByAge);
        commands.put(5, ui::finish);
    }

    public void execute(int commandNumber) {
        Runnable command = commands.get(commandNumber);
        if (command != null) {
            command.run();
        } else {
            System.out.println("Неизвестная команда.");
        }
    }

    public int getSize() {
        return commands.size();
    }

    public String menu() {
        return "1. Показать список людей\n" +
                "2. Добавить человека\n" +
                "3. Сортировать по имени\n" +
                "4. Сортировать по возрасту\n" +
                "5. Завершить работу";
    }
}
