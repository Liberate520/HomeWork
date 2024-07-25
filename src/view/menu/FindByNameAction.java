package view.menu;

import view.UserInterface;

public class FindByNameAction extends MenuCommand {
    public FindByNameAction(UserInterface userInterface) {
        super("Поиск человека по имени.", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().findByName();
    }
}
