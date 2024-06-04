/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * class CommandMenu
 * @version v1.0
 */

package family_true.view.commands;

import family_true.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class CommandMenu {

    List<Command> commands;

    public CommandMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new EntityGetList(consoleUI));
        commands.add(new EntityAdd(consoleUI));
        commands.add(new EntityAddParent(consoleUI));
        commands.add(new EntitySortById(consoleUI));
        commands.add(new EntitySortByLastName(consoleUI));
        commands.add(new EntitySortByBirthDay(consoleUI));
        commands.add(new EntityExport(consoleUI));
        commands.add(new EntityImport(consoleUI));
        commands.add(new FinishCommand(consoleUI));
    }

    public String getCommands() {
        StringBuilder builder = new StringBuilder();
        builder.append("Выберете команду:\n");
        for (int i = 0; i < commands.size(); i++) {
            builder.append(i+1);
            builder.append(". ");
            builder.append(commands.get(i).getDescription());
            builder.append("\n");
        }
        return builder.toString();
    }

    public void execute(int choice) {
        commands.get(choice - 1).execute();
    }

    public int getSize() {
        return commands.size();
    }
}
