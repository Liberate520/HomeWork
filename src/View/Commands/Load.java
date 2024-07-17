package View.Commands;

import View.ConsoleUI;

public class Load extends Command {
    public Load(ConsoleUI consoleUI) {
        super("Загрузить", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().Load();
    }
}
