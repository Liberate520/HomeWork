package ru.gb.family_tree.view.commands;
import ru.gb.family_tree.view.FamilyTreeView;

public class ShowChildren extends Command {
    public ShowChildren(FamilyTreeView view) {
        super(view);
        description = "Show children";
    }

    public void execute(){
        ((FamilyTreeView) view).showChildren();
    }
}