/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class Command
 * @version v1.0
 */

package family_true.view.commands;

import family_true.view.ConsoleUI;

/**
 * getEntityList
 * addEntity
 * addParent
 * sortById
 * sortByLastName
 * sortByBirthDay
 * export
 * import
 * exit
 */
public abstract class Command {

    private String description;
    private ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract void execute();
}
