package Presenter.Commands.ForFamilyTree;

import Model.Checks;
import Model.Creature.Entity;
import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class print extends Command implements Performing {
    private final View view;
    private final Tree familyTree;

    public print(View view, Tree familyTree){
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
            this.view.printMessage("ERROR", "Uncorrected character");

        } else {
            Entity entity = this.familyTree.getCreature(ID);

            if (entity == null){
                this.view.printMessage("ERROR", "Creature was not found");

            } else {
                this.view.println(entity.toString());
            }
        }
    }
}
