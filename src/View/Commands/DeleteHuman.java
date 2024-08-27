package View.Commands;

import View.ConsoleUI;

public class DeleteHuman extends Command{

    public DeleteHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Удалить человека из семейного дерева";
    }

    public void execute() {
        consoleUI.deleteHuman();
    }
}
