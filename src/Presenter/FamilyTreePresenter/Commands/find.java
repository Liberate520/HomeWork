package Presenter.FamilyTreePresenter.Commands;

import Model.Interface.Creature;
import Model.Interface.FamilyTreeInterface;
import Presenter.BaseClasses.Command;
import Presenter.Interface.Performing;
import View.Interface.FamilyTreeView;

public class find extends Command implements Performing {
    private FamilyTreeInterface<?> familyTree;
    private FamilyTreeView view;

    public find(FamilyTreeView view, FamilyTreeInterface<?> familyTree){
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

        for (Creature creature: this.familyTree.getCreature(name, surname)){
            this.view.println(creature.toString());
        }
    }
}
