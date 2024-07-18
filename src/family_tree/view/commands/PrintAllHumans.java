package family_tree.view.commands;

import family_tree.view.UserInterface;

public class PrintAllHumans extends Command {
    public PrintAllHumans (UserInterface userInterface) {
        super("Вывести список людей", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().printAllHumans();
    }

}
