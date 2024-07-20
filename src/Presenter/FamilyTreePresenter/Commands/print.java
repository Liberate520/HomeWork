package Presenter.FamilyTreePresenter.Commands;

import Model.Checks;
import Model.Interface.Creature;
import Model.Interface.FamilyTreeInterface;
import Presenter.BaseClasses.Command;
import Presenter.Interface.Performing;
import View.Interface.FamilyTreeView;

public class print extends Command implements Performing {
    private FamilyTreeView view;
    private FamilyTreeInterface<?> familyTree;

    public print(FamilyTreeView view, FamilyTreeInterface<?> familyTree){
        super("print", "Вывод существа по его ID");

        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        this.view.println("\tID: ");

        String creatureID = this.view.nextLine();

        Integer ID = Checks.parseInt(creatureID);

        if (ID == null){
            this.view.printSignedMessage("ERROR", "Uncorrected character");

        } else {
            Creature creature = this.familyTree.getCreature(ID);

            if (creature == null){
                this.view.printSignedMessage("ERROR", "Creature was not found");

            } else {
                this.view.println(creature.toString());
            }
        }
    }
}
