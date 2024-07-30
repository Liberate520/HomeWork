package Presenter.Commands.ForFamilyTree;

import Model.Checks;
import Model.Creature.Entity;
import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class set_mather extends Command implements Performing {
    private final Tree familyTree;
    private final View view;

    public set_mather(View view, Tree familyTree){
        super("set mather", "Изменить мать");

        this.familyTree = familyTree;
        this.view = view;
    }

    private void set(Entity entity){
        this.view.println("\tID new mather: ");

        String matherID = this.view.nextLine();

        if (matherID.equals("null"))
            entity.setMather(null);

        else{
            Integer intMatherID = Checks.parseInt(matherID);

            if (intMatherID == null) {
                this.view.printMessage("ERROR", "Uncorrected character");

            } else {
                Entity mather = this.familyTree.getCreature(intMatherID);

                if (mather == null) {
                    this.view.printMessage("ERROR", "Creature was not found");

                } else {
                    mather.addKid(entity);

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
