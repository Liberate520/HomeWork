package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public class AddInfo extends Actions {
    public AddInfo(ConsoleUI consoleUI) throws SecurityException, IOException {
        super("Добавить информацию о существующем члене семьи", consoleUI);
    }

    public void run() {
        getConsoleUI().addInfo();
    }
}
