package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class DownloadProject extends Command{

    public DownloadProject(ConsoleUI consoleUI) {

        super(consoleUI);
        description = "Загрузить проект";
    }

    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.downloadTree();
    }

}