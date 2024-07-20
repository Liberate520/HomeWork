package Presenter.DatabasePresenter.Commands;

import Model.Interface.DatabaseInterface;
import Model.Interface.FamilyTreeInterface;
import Presenter.BaseClasses.Command;
import Presenter.Interface.FamilyTreeRecipient;
import Presenter.Interface.Performing;
import View.Interface.DatabaseView;

public class new_tree extends Command implements Performing {
    private final FamilyTreeRecipient presenter;
    private final DatabaseInterface database;
    private final DatabaseView view;

    public new_tree(DatabaseView view, DatabaseInterface database, FamilyTreeRecipient presenter){
        super("new", "Создание нового дерева");

        this.presenter = presenter;
        this.database = database;
        this.view = view;
    }

    @Override
    public void execute() {
        this.view.println("\tKind of creature: ");

        FamilyTreeInterface<?> familyTree = database.createNewFamilyTree(this.view.nextLine());

        if (familyTree == null){
            view.printSignedMessage("ERROR", "Unknown creature");

        } else {
            presenter.setFamilyTree(familyTree);

            this.view.printSignedMessage("Result", "Successful");

            presenter.start();
        }
    }
}
