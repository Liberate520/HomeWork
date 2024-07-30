package Presenter.Commands.ForFamilyTree;

import Model.Checks;
import Model.Creature.Entity;
import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class add_kid extends Command implements Performing {
    private final Tree familyTree;
    private final View view;

    public add_kid(View view, Tree familyTree){
        super("add kid", "Добавить ребёнка");

        this.view = view;
        this.familyTree = familyTree;
    }

    private void add(Entity entity){
        this.view.println("\tID new kid: ");

        String kidID = this.view.nextLine();

        Integer intKidID = Checks.parseInt(kidID);

        if (intKidID == null){
            this.view.printMessage("ERROR", "Uncorrected character");
        } else {
            Entity kid = this.familyTree.getCreature(intKidID);

            if (kid == null){
                this.view.printMessage("ERROR", "Creature was not found");

            } else{
                entity.addKid(this.familyTree.getCreature(intKidID));

                this.view.printMessage("Result", "Successful");
            }
        }
    }

    @Override
    public void execute() {
        this.view.println("\thuman ID: ");

        Integer ID = Checks.parseInt(this.view.nextLine());

        if (ID == null)
            this.view.printMessage("ERROR", "Uncorrected character");

        else {
            Entity entity = this.familyTree.getCreature(ID);

            if (entity == null) {
                this.view.printMessage("ERROR", "The creature was not found");

            } else{
                add(entity);
            }
        }
    }
}
