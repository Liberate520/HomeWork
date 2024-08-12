package View.Commands.ForDatabase;

import View.Commands.Command;
import View.ConsoleUI;


public class ExitFromApp extends Command {

    public ExitFromApp(ConsoleUI consoleUI){
        super("exit", "Выход из семейного дерева", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().exit();
    }
}
