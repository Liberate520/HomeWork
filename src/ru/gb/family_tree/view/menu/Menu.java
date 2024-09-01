package ru.gb.family_tree.view.menu;

import ru.gb.family_tree.view.Console;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    private List<Command> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        setCommands();
    }

    protected Console getConsole() {
        return console;
    }

    protected abstract void setCommands();

    protected List<Command> getCommands() {
        return commands;
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(String choice){
        commands.get(Integer.parseInt(choice) - 1).execute();
    }
}
