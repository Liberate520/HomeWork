package family_tree.view.commands;

import family_tree.view.UserInterface;

public class SortHumansByName extends Command {
    public SortHumansByName(UserInterface userInterface) {
        super("Отсортированный список людей по имени", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().sortHumansByName();
    }
}
