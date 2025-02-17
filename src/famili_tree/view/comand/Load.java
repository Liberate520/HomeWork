package view.comand;

import view.ConsoleUI;

public class Load extends Command {

    public Load(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить семейное дерево";
    }

    public void execute() {
        consoleUI.load();
    }
}
