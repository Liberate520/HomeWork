package family_tree.view.consoleUI.commandsConsole;

import family_tree.view.consoleUI.ConsoleUI;

public abstract class Command {
    String name;
    ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getCommandName() {
        return name;
    }

    public abstract void execute();
}
