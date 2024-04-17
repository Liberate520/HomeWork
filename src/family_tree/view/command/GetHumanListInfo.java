package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class GetHumanListInfo extends Command {


    public GetHumanListInfo(ConsoleUI consoleUI) {
        super(consoleUI, "Получить список людей");
    }

    @Override
    public void execute() {
        getConsoleUI().getHumanListInfo();
    }

}
