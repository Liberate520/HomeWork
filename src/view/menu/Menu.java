package view.menu;

import view.command.Command;

import java.util.List;

public abstract class Menu {
    protected List<Command> commands;
    protected String menuName;

    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------------------\n");
        stringBuilder.append(menuName);
        stringBuilder.append("\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.append("------------------------");
        return stringBuilder.toString();
    }

    public void execute (int choice) {
        commands.get(choice).execute();
    }

    public List<Command> getCommands() {
        return commands;
    }
}
