package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetFamilyTreeInfo extends Command{
    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super("Получить список людей", consoleUI);
    }

    @Override
    public void execute(){
        consoleUI.getFamilyTreeInfo();
    }

}
