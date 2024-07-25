package view.commands.familyTies;

import view.ConsoleUi;
import view.commands.Command;

public class AddChild extends Command {

    public AddChild(ConsoleUi consoleUi) {
        super("Добавить ребенка", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().addChild();
    }
}
