package ru.gb.family_tree.view.commands;
import ru.gb.family_tree.view.FamilyTreeView;

public class ShowTree extends Command {
    public ShowTree(FamilyTreeView view) {
        super(view);
        description = "Show Tree";
    }

    public void execute(){
        ((FamilyTreeView) view).showTree();
    }
}