package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByBirthDate extends Command {

    public SortByBirthDate(ConsoleUI consoleUI) {
        super("Отсортировать людей по возрасту.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByBirthDate();
        getConsoleUI().getHumanListInfo();
    }

}
