package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortHumansByDOB extends Command{
    public SortHumansByDOB(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сортировать  список людей древа по дате рождения";
    }

    @Override
    public void execute() {
        consoleUI.sortHumansByDOB();
    }
}
