package View.Commands.ForDatabase;

import View.Commands.Command;
import View.ConsoleUI;

public class OpenSave extends Command{ ;
    public OpenSave(ConsoleUI consoleUI){
        super("open", "Загрузить сохранение", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().openSave();
    }
}
