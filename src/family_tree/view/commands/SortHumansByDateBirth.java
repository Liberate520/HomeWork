package family_tree.view.commands;

import family_tree.view.UserInterface;

public class SortHumansByDateBirth extends Command {
    public SortHumansByDateBirth(UserInterface userInterface) {
        super("Отсортированный список людей по дате рождения", userInterface);
    }

    @Override
    public void execute() {
        getUserInterface().sortHumansByDateBirth();
    }
}
