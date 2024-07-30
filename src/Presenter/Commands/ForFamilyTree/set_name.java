package Presenter.Commands.ForFamilyTree;

import Model.Checks;
import Model.Creature.Entity;
import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class set_name extends Command implements Performing {
    private final Tree familyTree;
    private final View view;

    public set_name(View view, Tree familyTree){
        super("set name", "Изменить имя");

        this.familyTree = familyTree;
        this.view = view;
    }

    private void set(Entity entity){
        this.view.println(String.format("\tCurrent nane: %s", entity.getName()));

        this.view.println("\tNew value: ");
        String newName = this.view.nextLine();

        if (newName.equals("null")) newName = null;

        entity.setName(newName);

        this.view.printMessage("Result", "Successful");
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
