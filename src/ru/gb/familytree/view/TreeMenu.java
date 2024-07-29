package ru.gb.familytree.view;



import ru.gb.familytree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class TreeMenu {

    private List<Command> commandList;

    public TreeMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddSomeBody(consoleUI));
        commandList.add(new GetTreeInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new Save(consoleUI));
        commandList.add(new Load(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String getMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список команд:\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choose) {
        Command command = commandList.get(choose - 1);
        command.execute();
    }

    public int sizeMenu() {
        return commandList.size();
    }
}
