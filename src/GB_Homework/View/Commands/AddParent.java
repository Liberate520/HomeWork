package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class AddParent extends Commands {

    private final String parentType;

    public AddParent(ConsoleUI consoleUI, String parentType) {
        super(consoleUI, "Добавить " + (parentType.equals("father") ? "отца" : "мать"));
        this.parentType = parentType;
    }

    @Override
    public void execute() {
        getConsoleUI().addParent(parentType);
    }
}