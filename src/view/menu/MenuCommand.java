package view.menu;

import view.UserInterface;

public abstract class MenuCommand {
    private final String description;
    private final UserInterface userInterface;

    public MenuCommand(String description, UserInterface userInterface) {
        this.description = description;
        this.userInterface = userInterface;
    }

    public String getDescription() {
        return description;
    }

    public UserInterface getUserInterface() {
        return userInterface;
    }

    public abstract void execute();

}
