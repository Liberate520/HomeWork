package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class GetHumanListInfo extends Command{

    public GetHumanListInfo(ConsoleUI consoleUI) {
        super("Получить список членов семьи", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getHumanListInfo();
    }
}
