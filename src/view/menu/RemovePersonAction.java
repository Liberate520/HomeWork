package view.menu;

import view.UserInterface;

public class RemovePersonAction extends MenuCommand {
    public RemovePersonAction(UserInterface userInterface) {
        super("Удалить человека", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().removePerson();
    }
}
