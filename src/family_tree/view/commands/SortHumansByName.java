package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortHumansByName  extends Command{
    public SortHumansByName(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сортировать  список людей древа по имени";
    }

    @Override
    public void execute() {
        consoleUI.searhHumansByName();
    }
}
