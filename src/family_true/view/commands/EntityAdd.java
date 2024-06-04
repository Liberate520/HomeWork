/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class EntityAdd
 * @version v1.0
 */

package family_true.view.commands;

import family_true.view.ConsoleUI;

public class EntityAdd extends Command {

    public EntityAdd(ConsoleUI consoleUI) {
        super("Добавить человека", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addEntity();
    }
}