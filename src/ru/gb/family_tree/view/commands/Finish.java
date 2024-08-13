package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.FamilyTreeView;

public class Finish extends Command {
    public Finish(FamilyTreeView view) {
        super(view);
        description = "Stop";
    }

    public void execute(){
        ((FamilyTreeView) view).finish();
    }
}
