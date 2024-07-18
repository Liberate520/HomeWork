package family_tree.view.commands;

import family_tree.view.UserInterface;

public abstract class Command {
    private final String description;
    public UserInterface userInterface;

    public Command(String description, UserInterface userInterface) {
        this.description = description;
        this.userInterface = userInterface;
    }

    UserInterface getUserInterface() {
        return userInterface;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute ();
}
