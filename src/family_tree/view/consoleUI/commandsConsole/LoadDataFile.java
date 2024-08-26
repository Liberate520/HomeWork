package family_tree.view.consoleUI.commandsConsole;

import family_tree.view.consoleUI.ConsoleUI;

public class LoadDataFile extends Command {

    public LoadDataFile(ConsoleUI consoleUI) {
        super(consoleUI);
        name = "Загрузить данные из файла";
    }

    @Override
    public void execute() {
        consoleUI.saveDataFile();
    }
}