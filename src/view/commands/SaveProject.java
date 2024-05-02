package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class SaveProject extends Command{

    public SaveProject(ConsoleUI consoleUI) {

        super(consoleUI);
        description = "Сохранить проект";
    }

        public void execute() throws IOException {
        consoleUI.saveTree();
    }

}