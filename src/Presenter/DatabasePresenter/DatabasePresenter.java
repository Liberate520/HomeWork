package Presenter.DatabasePresenter;

import Model.Interface.DatabaseInterface;
import Presenter.BaseClasses.Presenter;
import Presenter.DatabasePresenter.Commands.exit;
import Presenter.DatabasePresenter.Commands.new_tree;
import Presenter.Interface.DatabaseRecipient;
import Presenter.Interface.FamilyTreeRecipient;
import View.Interface.DatabaseView;


public class DatabasePresenter extends Presenter implements DatabaseRecipient {
    private final DatabaseView databaseView;

    public DatabasePresenter(DatabaseView databaseView, DatabaseInterface database, FamilyTreeRecipient secondPresenter) {
        super("Database presenter");

        this.databaseView = databaseView;

        this.databaseView.setPresenter(this);

        super.addCommand(new exit(databaseView));
        super.addCommand(new new_tree(this.databaseView, database, secondPresenter));
    }

    @Override
    public void acceptInput(String userInput) {
        if (userInput.isEmpty())
            this.databaseView.printSignedMessage("ERROR", "String cant be empty");

        if (!this.commandsList.containsKey(userInput))
            this.databaseView.printSignedMessage("ERROR", "Unknown command");

        else super.execute(userInput);
    }

    @Override
    public void start() {
        this.databaseView.mainLoop();
    }
}

