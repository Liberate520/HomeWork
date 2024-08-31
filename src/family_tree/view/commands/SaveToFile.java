package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SaveToFile extends Command{
    public SaveToFile(ConsoleUI consoleUI){
        super("Сохранить древо в файл", consoleUI);
    }
    @Override
    public void execute(){
        getConsoleUI().saveToFile();
    }
}
