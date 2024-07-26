package view.menu;

import view.UserInterface;

public class AddPersonAction extends MenuCommand {

    public AddPersonAction(UserInterface userInterface) {
        super("Добавить человека в дерево.", userInterface);
    }


    @Override
    public void execute() {
        getUserInterface().addPerson();
    }
}