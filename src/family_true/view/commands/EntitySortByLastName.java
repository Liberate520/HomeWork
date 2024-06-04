/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class EntitySortByLastName
 * @version v1.0
 */

package family_true.view.commands;

import family_true.view.ConsoleUI;

public class EntitySortByLastName extends Command {

    public EntitySortByLastName(ConsoleUI consoleUI) {
        super("Сортировка по фамилии", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByLastName();
    }
}
