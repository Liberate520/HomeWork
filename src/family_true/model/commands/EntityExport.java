/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class EntityExport
 * @version v1.0
 */

package family_true.model.commands;

import family_true.view.ConsoleUI;

public class EntityExport extends Command {

    public EntityExport(ConsoleUI consoleUI) {
        super("Экспортировать список (записать в файл)", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().exportList();
    }
}
