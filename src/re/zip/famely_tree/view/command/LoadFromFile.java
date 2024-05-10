package re.zip.famely_tree.view.command;

import re.zip.famely_tree.view.ConsoleUI;

public class LoadFromFile extends Command{

    public LoadFromFile (ConsoleUI consoleUI) {
        super("Загрузить дерево из файла", consoleUI);
    }

    String filePath = "C:\\Users\\Asus\\IdeaProjects\\famely_tree\\src\\re\\zip\\famely_tree\\model\\service\\writer\\tree.sav";


    @Override
    public void execute() {
        getConsoleUI().loadFromFile(filePath);
    }
}
