package View.Commands;

import View.ConsoleUI;

public class GetFamilyTreeInfoCommand extends Command{

    public GetFamilyTreeInfoCommand(ConsoleUI consoleUI) {
        super("Показать дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getFamilyTreeInfo();
    }
}
