package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class GetHumanInfo extends Command {
    public GetHumanInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список людей";
    }

    public void execute(){
        consoleUI.getHumanListInfo();
    }
}
