package com.oop.homeWorkOOP.view;

import com.oop.homeWorkOOP.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI cons) {
        commandList = new ArrayList<>();
        commandList.add(new GetLineAgeInfo(cons));
        commandList.add(new SortTreeByNameCommand(cons));
        commandList.add(new SortByBirthDateCommand(cons));
        commandList.add(new AddHumanCommand(cons));
        commandList.add(new GetHumanByName(cons));
        commandList.add(new LoadTreeCommand(cons));
        commandList.add(new SaveTreeCommand(cons));
        commandList.add(new ExitCommand(cons));
    }

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

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }

}
