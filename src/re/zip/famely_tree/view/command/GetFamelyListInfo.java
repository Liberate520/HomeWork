package re.zip.famely_tree.view.command;

import re.zip.famely_tree.view.ConsoleUI;

public class GetFamelyListInfo extends Command{

    public GetFamelyListInfo(ConsoleUI consoleUI) {
        super("Вывести семейное дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getFamelyListInfo();
    }
}
