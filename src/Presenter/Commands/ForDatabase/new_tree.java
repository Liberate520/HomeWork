package Presenter.Commands.ForDatabase;

import Model.FamilyTree.FamilyTree;
import Presenter.Commands.Command;
import Presenter.Recipient;
import Presenter.Commands.Performing;
import View.View;

public class new_tree extends Command implements Performing {
    private final View view;
    private final Recipient presenter;

    public new_tree(View view, Recipient presenter){
        super("new", "Создание нового дерева");

        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void execute() {
        this.view.println("\tDescription: ");
        String description = this.view.nextLine();

        presenter.setFamilyTree(new FamilyTree(description));

        this.view.setConsoleName("Family tree");

        this.presenter.setCurrentCommands(this.presenter.getFamilyTreeCommands());

        this.view.printMessage("Result", "Successful");
    }
}
