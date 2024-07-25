package view.commands.familyTies;

import view.ConsoleUi;
import view.commands.Command;

public class SetMother extends Command {

    public SetMother(ConsoleUi consoleUi) {
        super("Назначить мать", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().setMother();
    }
}
