package View.Commands;

import View.ConsoleUI;

public class AddStudent extends Command {

    public AddStudent(ConsoleUI consoleUI) {
        super("Добавление члена семьи", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().add();
    }
}
