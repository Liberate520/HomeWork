package view.commands;

import view.ConsoleUi;

public class GetPersonListInfo extends Command {

    public GetPersonListInfo(ConsoleUi consoleUi) {
        super("Получить список семьи", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().getPersonListInfo();
    }
}
