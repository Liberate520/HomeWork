package Presenter.FamilyTreePresenter.Commands;

import Model.Checks;
import Model.Interface.Creature;
import Model.Interface.FamilyTreeInterface;
import Presenter.BaseClasses.Command;
import Presenter.Interface.Performing;
import View.Interface.FamilyTreeView;

public class del extends Command implements Performing {
    private final FamilyTreeView view;
    private final FamilyTreeInterface<?> familyTree;

    public del(FamilyTreeView view, FamilyTreeInterface<?> familyTree){
        super("del", "Удаление существа из древа");

        this.view = view;
        this.familyTree = familyTree;
    }

    @Override
    public void execute() {
        this.view.println("\tID: ");

        Integer ID = Checks.parseInt(this.view.nextLine());

        if (ID == null){
            this.view.printSignedMessage("ERROR", "Uncorrected character");

        } else {
            Creature<?> creature = this.familyTree.getCreature(ID);

            if (creature == null){
                this.view.printSignedMessage("ERROR", "The creature was not found");

            } else {
                this.familyTree.removeCreature(ID);

                this.view.printSignedMessage("Result", "Successful");
            }
        }
    }
}
