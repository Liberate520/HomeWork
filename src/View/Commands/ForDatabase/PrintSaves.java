package View.Commands.ForDatabase;

import View.Commands.Command;
import View.ConsoleUI;

public class PrintSaves extends Command{
    public PrintSaves(ConsoleUI consoleUI){
        super("print saves", "Вывод сохранённых семейных деревьев", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().printSaves();
    }
}
