package view.commands;

import view.ConsoleUi;

public class AddPerson extends Command {

    public AddPerson(ConsoleUi consoleUi) {
        super("Добавить члена семьи", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().addPerson();
    }
}
