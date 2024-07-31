package view.commands.add;

import view.ConsoleUI;
import view.commands.Command;

public class AddChild extends Command {
    public AddChild(ConsoleUI consoleUI) {
        super("Добавить ребенка к матери/отцу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addChild();
    }
}
