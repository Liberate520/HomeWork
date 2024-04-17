package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class LoadTreeFromFile extends Command {


    public LoadTreeFromFile(ConsoleUI consoleUI) {
        super(consoleUI, "Загрузить из файла");
    }

    @Override
    public void execute() {
        getConsoleUI().loadTreeFromFile();
    }

}
