package Presenter.FamilyTreePresenter;

import Model.Interface.FamilyTreeInterface;
import Presenter.BaseClasses.Presenter;
import Presenter.FamilyTreePresenter.Commands.*;
import Presenter.Interface.FamilyTreeRecipient;
import View.Interface.FamilyTreeView;

import java.util.ArrayList;

public class FamilyTreePresenter extends Presenter implements FamilyTreeRecipient {
    private final FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeView view) {
        super("Family tree presenter");

        this.view = view;

        this.view.setPresenter(this);

        super.addCommand(new exit(view));

    }

    public void setFamilyTree(FamilyTreeInterface<?> familyTree){
        if (familyTree != null){
            super.addCommand(new print_tree(this.view, familyTree));
            super.addCommand(new add(this.view, familyTree));
            super.addCommand(new del(this.view, familyTree));
            super.addCommand(new set(this.view, familyTree));
            super.addCommand(new set(this.view, familyTree));
            super.addCommand(new find(this.view, familyTree));
            super.addCommand(new print(this.view, familyTree));
            super.addCommand(new sort_by_name(this.view, familyTree));
            super.addCommand(new sort_by_surname(this.view, familyTree));
            super.addCommand(new sort_by_ID(this.view, familyTree));
            super.addCommand(new sort_by_children(this.view, familyTree));

            super.addCommand(new commands(this.view, new ArrayList<>(this.commandsList.values())));
        }
    }

    @Override
    public void acceptInput(String userInput) {
        if (userInput.isEmpty())
            this.view.printSignedMessage("ERROR", "String cant be empty");

        if (!this.commandsList.containsKey(userInput))
            this.view.printSignedMessage("ERROR", "Unknown command");

        else super.execute(userInput);
    }

    @Override
    public void start() {
        this.view.mainLoop();
    }
}
