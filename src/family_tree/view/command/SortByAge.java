package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class SortByAge extends Command {


    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI, "Отсортировать по возрасту");
    }

    @Override
    public void execute() {
        getConsoleUI().sortByAge();
    }

}
