package family_tree.view.consoleUI.commandsConsole;

import family_tree.view.consoleUI.ConsoleUI;

public class SaveDataFile extends Command {

    public SaveDataFile(ConsoleUI consoleUI) {
        super(consoleUI);
        name = "Сохранить данные в файл";
    }

    @Override
    public void execute() {
        consoleUI.saveDataFile();
    }
}
