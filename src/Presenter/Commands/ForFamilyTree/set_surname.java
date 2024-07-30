package Presenter.Commands.ForFamilyTree;

import Model.Checks;
import Model.Creature.Entity;
import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class set_surname extends Command implements Performing {
    private final Tree familyTree;
    private final View view;

    public set_surname(View view, Tree familyTree){
        super("set surname", "Изменить фамилию");

        this.familyTree = familyTree;
        this.view = view;
    }

    private void set(Entity entity){
        this.view.println(String.format("\tCurrent surname: %s", entity.getName()));

        this.view.println("\tNew value: ");
        String newSurname = this.view.nextLine();

        if (newSurname.equals("null")) newSurname = null;

        entity.setSurname(newSurname);

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
