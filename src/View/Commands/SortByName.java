package View.Commands;

import Presenter.Presenter;
import View.Command;
import View.MainMenu;

public class SortByName extends Command {

    public SortByName() {
        super("Сортировать по имени");
    }

    @Override
    public void execute() {
        presenter.sortByName();
    }
}
