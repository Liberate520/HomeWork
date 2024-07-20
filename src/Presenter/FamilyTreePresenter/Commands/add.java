package Presenter.FamilyTreePresenter.Commands;

import Model.Creatures.Gender.Gender;
import Model.Interface.FamilyTreeInterface;
import Presenter.BaseClasses.Command;
import Presenter.Interface.Performing;
import View.Interface.FamilyTreeView;

public class add extends Command implements Performing {
    private final FamilyTreeInterface<?> familyTree;
    private final FamilyTreeView view;

    public add(FamilyTreeView view, FamilyTreeInterface<?> familyTree){
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

        if (gender == null)
            familyTree.addCreature(name, surname, null);

        else {
            if (gender.equalsIgnoreCase(Gender.male.toString())) {
                familyTree.addCreature(name, surname, Gender.male);

                this.view.printSignedMessage("Result", "Successful");

            } else if (gender.equalsIgnoreCase(Gender.female.toString())) {
                familyTree.addCreature(name, surname, Gender.female);

                this.view.printSignedMessage("Result", "Successful");

            } else this.view.printSignedMessage("ERROR", "Unknown gender");
        }
    }
}
