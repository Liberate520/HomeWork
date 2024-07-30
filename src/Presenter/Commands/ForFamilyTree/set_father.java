package Presenter.Commands.ForFamilyTree;

import Model.Checks;
import Model.Creature.Entity;
import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class set_father extends Command implements Performing {
    private final Tree familyTree;
    private final View view;

    public set_father(View view, Tree familyTree){
        super("set father", "Изменить отца");

        this.familyTree = familyTree;
        this.view = view;
    }

    private void set(Entity entity){
        this.view.println("\tID new mather: ");

        String fatherID = this.view.nextLine();

        if (fatherID.equals("null"))
            entity.setFather(null);

        else{
            Integer intFatherID = Checks.parseInt(fatherID);

            if (intFatherID == null) {
                this.view.printMessage("ERROR", "Uncorrected character");

            } else {
                Entity father = this.familyTree.getCreature(intFatherID);

                if (father == null) {
                    this.view.printMessage("ERROR", "Creature was not found");

                } else {
                    father.addKid(entity);

                    this.view.printMessage("Result", "Successful");
                }
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
                set(entity);
            }
        }
    }
}
