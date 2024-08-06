package view.commands;

import view.ConsoleUI;

public class StartAddDataMenu extends Command {
    public StartAddDataMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Меню добавления данных и связей";
    }

    @Override
    public void execute() {
        consoleUI.startAddDataMenu();
    }
}