package family_tree.view.consoleUI.commandsConsole;

import family_tree.view.consoleUI.ConsoleUI;

public class RegisterDeath extends Command {

    public RegisterDeath(ConsoleUI consoleUI) {
        super(consoleUI);
        name = "Зарегистрировать дату смерти";
    }

    @Override
    public void execute() {
        consoleUI.registerDeath();
    }
}
