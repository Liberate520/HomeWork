package view.commands.basemenu;

import view.ConsoleUi;
import view.commands.Command;

public class Finish extends Command {

    public Finish(ConsoleUi consoleUi) {
        super("Выход из программы", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().finish();
    }
}
