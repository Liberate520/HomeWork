package family_tree.view.commands;

import family_tree.view.UserInterface;

public class AddHuman extends Command {
    public AddHuman (UserInterface userInterface) {
        super("Добавить человека", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().addHuman();
    }

}
