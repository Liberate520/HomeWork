package ru.gb.family_tree.view.commands;
import ru.gb.family_tree.view.FamilyTreeView;

public class SortByBirthDate extends Command {
    public SortByBirthDate(FamilyTreeView view) {
        super(view);
        description = "Sort by birthdate";
    }

    public void execute(){
        ((FamilyTreeView) view).sortByBirthDate();
    }
}