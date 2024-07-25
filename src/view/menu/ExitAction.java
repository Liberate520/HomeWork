package view.menu;

import view.UserInterface;

public class ExitAction extends MenuCommand {
    public ExitAction(UserInterface userInterface) {
        super("Выход", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().exit();
    }
}