package Presenter.Commands.ForFamilyTree;

import Model.Creature.Creature;
import Model.Creature.Gender;
import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class add extends Command implements Performing {
    private final Tree familyTree;
    private final View view;

    public add(View view, Tree familyTree){
        super("add", "Добавление существа в древо");

        this.view = view;
        this.familyTree = familyTree;
    }

    @Override
    public void execute() {
        String name, surname, gender;

        this.view.println("\tName: ");
        name = this.view.nextLine();

        if (name.equals("null"))
            name = null;

        this.view.println("\tSurname: ");
        surname = this.view.nextLine();

        if (surname.equals("null"))
            surname = null;

        this.view.println("\tGender: ");
        gender = this.view.nextLine();

        int ID = this.familyTree.getLastHumanID();

        if (gender == null)
            familyTree.addCreature(new Creature(name, surname, null, ID));

        else {
            if (gender.equalsIgnoreCase(Gender.male.toString())) {
                familyTree.addCreature(new Creature(name, surname, Gender.male, ID));

                this.view.printMessage("Result", "Successful");

            } else if (gender.equalsIgnoreCase(Gender.female.toString())) {
                familyTree.addCreature(new Creature(name, surname, Gender.female, ID));

                this.view.printMessage("Result", "Successful");

            } else this.view.printMessage("ERROR", "Unknown gender");
        }
    }
}
