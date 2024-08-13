package ru.gb.family_tree.view.commands;
import ru.gb.family_tree.view.FamilyTreeView;

public class SortByName extends Command {
    public SortByName(FamilyTreeView view) {
        super(view);
        description = "Sort by name";
    }

    public void execute(){
        ((FamilyTreeView) view).sortByName();
    }
}