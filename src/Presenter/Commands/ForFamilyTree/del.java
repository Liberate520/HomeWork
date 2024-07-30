package Presenter.Commands.ForFamilyTree;

import Model.Checks;
import Model.Creature.Entity;
import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class del extends Command implements Performing {
    private final View view;
    private final Tree familyTree;

    public del(View view, Tree familyTree){
        super("del", "Удаление существа из древа");

        this.view = view;
        this.familyTree = familyTree;
    }

    @Override
    public void execute() {
        this.view.println("\tID: ");

        Integer ID = Checks.parseInt(this.view.nextLine());

        if (ID == null){
            this.view.printMessage("ERROR", "Uncorrected character");

        } else {
            Entity entity = this.familyTree.getCreature(ID);

            if (entity == null){
                this.view.printMessage("ERROR", "The creature was not found");

            } else {
                this.familyTree.removeCreature(ID);

                this.view.printMessage("Result", "Successful");
            }
        }
    }
}
