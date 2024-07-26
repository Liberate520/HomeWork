package view.menu;

import view.UserInterface;

public class DisplayTreeAction extends MenuCommand {
    public DisplayTreeAction(UserInterface userInterface) {
        super("Показать дерево", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().getInfoTree();
    }
}