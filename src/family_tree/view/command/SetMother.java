package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class SetMother extends Command{
    public SetMother(ConsoleUI consoleUI) {
        super("Добавить маму", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setMother();
    }
}
