package Presenter.Commands.ForFamilyTree;

import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import Presenter.Recipient;
import View.View;

public class exit extends Command implements Performing {
    private final Recipient presenter;
    private final View view;

    public exit(View view, Recipient presenter){
        super("exit", "Выход из семейного дерева");

        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        this.view.setConsoleName("Database");

        this.presenter.setCurrentCommands(this.presenter.getDatabaseCommands());
    }
}
