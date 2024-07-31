package view.extraMenus;

import view.ConsoleUI;
import view.commands.Command;
import view.commands.fileOperations.ReadFile;
import view.commands.fileOperations.SaveFile;
import view.commands.fileOperations.ShowCurrentFilePath;

import java.util.ArrayList;
import java.util.List;

public class FileMenu {
    private List<Command> commands;

    public FileMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new ReadFile(consoleUI));
        commands.add(new SaveFile(consoleUI));
        commands.add(new ShowCurrentFilePath(consoleUI));
    }

    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nМеню по работе с файлами:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }
}
