package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class SaveTree extends Command{

    public SaveTree(ConsoleUI consoleUI) {
        super("Сохранить список членов семьи", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveTree();
    }
}
