package Presenter.Commands.ForFamilyTree;

import Model.Creature.Entity;
import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class find extends Command implements Performing {
    private final Tree familyTree;
    private final View view;

    public find(View view, Tree familyTree){
        super("find", "Найти человека по имени и фамилии");

        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        this.view.println("\tName: ");
        String name = this.view.nextLine();

        this.view.println("\tSurname: ");
        String surname = this.view.nextLine();

        for (Entity entity : this.familyTree.getCreature(name, surname)){
            this.view.println(entity.toString());
        }
    }
}
