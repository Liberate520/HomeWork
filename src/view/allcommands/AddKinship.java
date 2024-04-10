package view.allcommands;

import view.ConsoleUI;

public class AddKinship extends Command{
    public AddKinship(ConsoleUI consoleUI) {
        super(consoleUI);
        description="Добавить родственные связи";
    }

    @Override
    public void execute() {
        consoleUI.addKinship();
    }
}
