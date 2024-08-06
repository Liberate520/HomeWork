package ru.gb2.family_tree7.view;

import ru.gb2.family_tree7.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new GetHumanInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByGender(consoleUI));
        commandList.add(new SortByBirthDate(consoleUI));
        commandList.add(new SortByDeathDate(consoleUI));
        commandList.add(new SortByParents(consoleUI));
        commandList.add(new SortByChildren(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}

