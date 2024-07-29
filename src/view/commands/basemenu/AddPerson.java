package view.commands.basemenu;

import view.ConsoleUi;
import view.commands.Command;

public class AddPerson extends Command {

    public AddPerson(ConsoleUi consoleUi) {
        super("Добавить члена семьи", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().addPerson();
    }
}
