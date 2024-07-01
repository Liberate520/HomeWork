package ru.gb.family_tree.view.commands.mainMenu;

import ru.gb.family_tree.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class MenuMain {
    private List<Command> commands;

    public MenuMain(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new workWithElement(consoleUI));
        commands.add(new workWithTree(consoleUI));
        commands.add(new loadTree(consoleUI));
        commands.add(new saveTree(consoleUI));
        commands.add(new showCurrentTree(consoleUI));
        commands.add(new finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Главное меню:\n");
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
