/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class EntityGetList
 * @version v1.0
 */

package family_true.view.commands;

import family_true.view.ConsoleUI;

public class EntityGetList extends Command{

    public EntityGetList(ConsoleUI consoleUI) {
        super("Получить список людей", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getEntityListInfo();
    }
}