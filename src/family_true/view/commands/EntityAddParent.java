/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class EntityAddParent
 * @version v1.0
 */

package family_true.view.commands;

import family_true.view.ConsoleUI;

public class EntityAddParent extends Command {

    public EntityAddParent(ConsoleUI consoleUI) {
        super("Добавить родителя", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addParent();
    }
}
