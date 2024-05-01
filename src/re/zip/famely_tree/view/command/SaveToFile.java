package re.zip.famely_tree.view.command;

import re.zip.famely_tree.view.ConsoleUI;

public class SaveToFile extends Command{

    public SaveToFile (ConsoleUI consoleUI) {
        super("Сохранить дерево в файл", consoleUI);
    }

    // пока так
    String filePath = "C:\\Users\\Asus\\IdeaProjects\\famely_tree\\src\\re\\zip\\famely_tree\\model\\service\\writer\\tree.sav";


    @Override
    public void execute() {
        getConsoleUI().saveToFile(filePath);
    }
}