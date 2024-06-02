/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class FinishCommand
 * @version v1.0
 */

package family_true.model.commands;

import family_true.view.ConsoleUI;

public class FinishCommand extends Command {

    public FinishCommand(ConsoleUI consoleUI) {
        super("Выход", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}