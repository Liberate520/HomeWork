package View.Commands;

import View.ConsoleUI;
import View.View;

public class AddHuman extends Command{

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека в семейное дерево";
    }

    public void execute() {
        consoleUI.addHuman();
    }
}
