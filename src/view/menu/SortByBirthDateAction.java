package view.menu;

import view.UserInterface;

public class SortByBirthDateAction extends MenuCommand {
    public SortByBirthDateAction(UserInterface userInterface) {
        super("Сортировка людей по дате рождения", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().sortByBirthDate();
    }
}