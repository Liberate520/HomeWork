package view.menu;

import view.UserInterface;

public class SortByNameAction extends MenuCommand {
    public SortByNameAction(UserInterface userInterface) {
        super("Сортировка людей по имени", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().sortByName();
    }
}