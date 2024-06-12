package view.menu;

import view.ConsoleUI;
import view.commands.Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu implements Menu {

    protected List<Command> commandList;

    public AbstractMenu(ConsoleUI consoleUI) {

    }

    protected AbstractMenu() {
    }

    @Override
    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commandList.get(choice-1);
        command.execute();
    }
    public int getSize(){
        return commandList.size();
    }
}

