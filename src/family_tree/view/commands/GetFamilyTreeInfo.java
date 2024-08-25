package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetFamilyTreeInfo extends Command{
    public GetFamilyTreeInfo(ConsoleUI consoleUI){
        super("Получить семейное древо", consoleUI);
    }
    @Override
    public void execute(){
        getConsoleUI().getFamilyTreeInfo();
    }
}
