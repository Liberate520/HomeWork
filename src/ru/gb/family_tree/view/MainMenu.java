package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHumanCommand(consoleUI));
        commands.add(new AddFamilyConnectionCommand(consoleUI));
        commands.add(new GetFamilyTreeInfoCommand(consoleUI));
        commands.add(new SortCommands(consoleUI));
        //commands.add(new SortByFirstNameCommand(consoleUI));
       // commands.add(new SortByAgeCommand(consoleUI));
        commands.add(new FinishCommand(consoleUI));
    }

    public String showMainMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Главное меню: \n");
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
