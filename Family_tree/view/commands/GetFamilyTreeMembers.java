package Family_tree.view.commands;

import Family_tree.view.ConsoleUI;

public class GetFamilyTreeMembers extends Command{
        public GetFamilyTreeMembers(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "I want to see family members list";
    }

    public void execute() {
        consoleUI.getFamilyTreeMembers();
    }
}
