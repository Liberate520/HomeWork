package View.Commands;

import Presenter.Presenter;
import View.Command;
import View.ConsoleUI;
import View.MainMenu;

public class CloseMenu extends Command {
    
    public CloseMenu() {
        super("Закрыть меню");
        ;
    }

    @Override
    public void execute() {
        ConsoleUI consoleUI = ConsoleUI.getInstance();
        consoleUI.stopMenu();
        System.out.println("Работа завершена");
    }

}
