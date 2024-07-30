package Presenter.Commands.ForFamilyTree;

import Model.Checks;
import Model.Creature.Entity;
import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

import java.util.ArrayList;

public class set_spouse extends Command implements Performing {
    private final Tree familyTree;
    private final View view;

    public set_spouse(View view, Tree familyTree){
        super("set spouse", "Изменить супруга");

        this.familyTree = familyTree;
        this.view = view;
    }

    private void set(Entity entity){
        this.view.println("\tID new spouse: ");

        String spouseID = this.view.nextLine();

        if (spouseID.equals("null"))
            entity.setSpouse(null);

        else{
            Integer intSpouseID = Checks.parseInt(spouseID);

            if (intSpouseID == null) {
                this.view.printMessage("ERROR", "Uncorrected character");

            } else {
                Entity spouse = this.familyTree.getCreature(intSpouseID);

                if (spouse == null) {
                    this.view.printMessage("ERROR", "Creature was not found");

                } else {
                    entity.setSpouse(spouse);

                    ArrayList<Entity> spouseChildren = new ArrayList<>(spouse.getChildren());

                    spouse.addChildren(entity.getChildren());

                    entity.addChildren(spouseChildren);

                    spouse.setSpouse(entity);

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
