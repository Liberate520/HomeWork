/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class EntityByDate
 * @version v1.0
 */

package family_true.view.commands;

import family_true.view.ConsoleUI;

public class EntitySortByBirthDay extends Command{

    public EntitySortByBirthDay(ConsoleUI consoleUI) {
        super("Сортировка по дате", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByBirthDay();
    }
}