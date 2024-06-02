/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class Command
 * @version v1.0
 */

package family_true.model.commands;

import family_true.view.ConsoleUI;

/**
 * addEntity
 * getEntityList
 * sortByLastName
 * sortByDate
 * sortById
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
