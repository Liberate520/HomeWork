/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class EntitySortById
 * @version v1.0
 */

package family_true.view.commands;

import family_true.view.ConsoleUI;

public class EntitySortById extends Command{

    public EntitySortById(ConsoleUI consoleUI) {
        super("Сортировка по индексу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortById();
    }
}
