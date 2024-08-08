package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetList extends Command {
    public GetList(ConsoleUI consoleUI) {
        super(consoleUI, "Получить список семейного древа");
    }

    @Override
    public void execute() {
        getConsoleUI().getHumanListInfo();

    }
}
