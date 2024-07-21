package View.Commands;

import Presenter.Presenter;
import View.Command;
import View.MainMenu;

public class CloseMenu extends Command {

    public CloseMenu() {
        super("Закрыть меню");
    }

    @Override
    public void execute() {
        System.out.println("Работа завершена");
    }

}
