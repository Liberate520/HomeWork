package ru.gb.family_tree.view.commands.treeRedact;

import ru.gb.family_tree.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class MenuRedactTree {
    private List<Command> commands;

    public MenuRedactTree(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new sortByName(consoleUI));
        commands.add(new sortById(consoleUI));
        commands.add(new sortByGender(consoleUI));
        commands.add(new sortByDob(consoleUI));
        commands.add(new sortByDod(consoleUI));
        commands.add(new showCurrentTree(consoleUI));
        commands.add(new back(consoleUI));

    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Сортировать по...:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choise){
        Command command = commands.get(choise - 1);
        command.execute();
    }

    public int size(){
        return commands.size();
    }
}
