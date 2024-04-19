package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class AddSubject extends Command {

    public AddSubject(ConsoleUI consoleUI) {
        super("Add subject to family tree", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().addNewSubjectToFamilyTree();
    }
}
