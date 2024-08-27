package View.Commands;

import View.ConsoleUI;

public class ShowFamilyTreeInfo extends Command{

    public ShowFamilyTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отобразить семейное дерево";
    }

    public void execute() {
        consoleUI.showFamilyTreeInfo();
    }
}
