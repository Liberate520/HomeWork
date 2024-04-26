package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class SaveTreeToFile extends Command {


    public SaveTreeToFile(ConsoleUI consoleUI) {
        super(consoleUI, "Сохранить в файл");
    }

    @Override
    public void execute() {
        getConsoleUI().saveTreeToFile();
    }

}
