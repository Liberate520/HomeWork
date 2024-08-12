package View.Commands.Common;

import View.Commands.Command;
import View.ConsoleUI;

public class PrintCommands extends Command{
    public PrintCommands(ConsoleUI consoleUI){
        super("commands", "Вывод доступных команд", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().printCommands();
    }
}
