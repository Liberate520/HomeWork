package family_tree.view.commands;

import family_tree.view.UserInterface;

public class FindHuman extends Command {
    public FindHuman (UserInterface userInterface) {
        super("Найти человека", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().findHuman();
    }
}
