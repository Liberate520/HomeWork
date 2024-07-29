package view.commands.familyTies;

import view.ConsoleUi;
import view.commands.Command;

public class FamilyTies extends Command {

    public FamilyTies(ConsoleUi consoleUi) {
        super("Обозначить родственные связи", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().familyTies();
    }
}
