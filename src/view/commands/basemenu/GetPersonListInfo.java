package view.commands.basemenu;

import view.ConsoleUi;
import view.commands.Command;

public class GetPersonListInfo extends Command {

    public GetPersonListInfo(ConsoleUi consoleUi) {
        super("Получить список семьи", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().getPersonListInfo();
    }
}
