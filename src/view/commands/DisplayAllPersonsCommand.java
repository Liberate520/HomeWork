package view.commands;

import presenter.Presenter;
import view.Command;

public class DisplayAllPersonsCommand implements Command {
    private Presenter presenter;

    public DisplayAllPersonsCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.displayAllPersons();
    }

    @Override
    public String getName() {
        return "display";
    }
}
