package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class LoadFromFile extends Command{
    public LoadFromFile(ConsoleUI consoleUI){
        super("Загрузить древо из файла", consoleUI);
    }
    @Override
    public void execute(){
        getConsoleUI().loadFromFile();
    }
}
