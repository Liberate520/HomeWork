package family_tree.view.commands;

import family_tree.view.UserInterface;

public class Finish extends Command {
    public Finish (UserInterface userInterface) {
        super("Завершить работу", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().finish();
    }
}
