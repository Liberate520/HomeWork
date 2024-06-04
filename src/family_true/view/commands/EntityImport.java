/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class EntitySave
 * @version v1.0
 */

package family_true.view.commands;

import family_true.view.ConsoleUI;

public class EntityImport extends Command {

    public EntityImport(ConsoleUI consoleUI) {
        super("Импортировать список (прочитать из файла)", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().importList();
    }
}