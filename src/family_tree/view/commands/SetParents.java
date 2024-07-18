package family_tree.view.commands;

import family_tree.view.UserInterface;

public class SetParents extends Command{
    public SetParents (UserInterface userInterface) {
        super("Установить родственные связи", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().setParents();
    }
}
