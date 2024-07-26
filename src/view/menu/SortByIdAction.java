package view.menu;

import view.UserInterface;

public class SortByIdAction extends MenuCommand {
    public SortByIdAction(UserInterface userInterface) {
        super("Сортировка людей по ID", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().sortById();
    }
}
