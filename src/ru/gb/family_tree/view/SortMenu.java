package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class SortMenu {
    private List<Command> commands;

    public SortMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new SortByAgeCommand(consoleUI));
        commands.add(new SortByFirstNameCommand(consoleUI));
        commands.add(new BackToMainMenuCommand(consoleUI));
        commands.add(new FinishCommand(consoleUI));
        }

    public String showSortMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню сортировки: \n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1+". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commands.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return  commands.size();
    }
}
