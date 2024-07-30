package Presenter.Commands.ForFamilyTree;

import Model.Checks;
import Model.Creature.Entity;
import Model.Creature.Gender;
import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class set_gender extends Command implements Performing {
    private final Tree familyTree;
    private final View view;

    public set_gender(View view, Tree familyTree){
        super("set gender", "Изменить пол");

        this.familyTree = familyTree;
        this.view = view;
    }

    private void set(Entity entity){
        this.view.println(String.format("\tCurrent gender: %s", entity.getGender()));

        this.view.println("New gender: ");
        String gender = this.view.nextLine();

        if (gender.equals("null")){
             entity.setGender(null);

        } else{
            if (gender.equalsIgnoreCase(Gender.male.toString())){
                entity.setGender(Gender.male);

                this.view.printMessage("Result", "Successful");

            } else if (gender.equalsIgnoreCase(Gender.female.toString())){
                entity.setGender(Gender.female);

                this.view.printMessage("Result", "Successful");

            } else this.view.printMessage("ERROR", "Unknown gender");
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
