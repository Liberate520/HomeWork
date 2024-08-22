package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class SetParentId extends Command{

    public SetParentId(ConsoleUI consoleUI) {
        super("Добавить данные о родителе", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setParentId();
    }
}