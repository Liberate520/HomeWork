package view.commands.familyTies;

import view.ConsoleUi;
import view.commands.Command;

public class SetFather extends Command {

    public SetFather(ConsoleUi consoleUi) {
        super("Назначить отца", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().setFather();
    }
}
