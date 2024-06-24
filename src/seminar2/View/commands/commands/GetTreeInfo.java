package seminar2.View.commands.commands;

import seminar2.View.commands.ConsoleUI;

public class GetTreeInfo extends Command{

    public GetTreeInfo(ConsoleUI consoleUI) {
        super("вывод семейного дерева", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().getTreeInfo();
    }
}
