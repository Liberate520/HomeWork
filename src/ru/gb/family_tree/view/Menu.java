package ru.gb.family_tree.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import ru.gb.family_tree.view.commands.Command;

public abstract class Menu {
    private List<Command> commandList;

    public Menu(ConsoleUI consoleUI, List<Command> commands) {
        commandList = commands;
    }

    String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    void execute(int choice) throws FileNotFoundException, ClassNotFoundException, IOException {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    int getSize() {
        return commandList.size();
    }
}