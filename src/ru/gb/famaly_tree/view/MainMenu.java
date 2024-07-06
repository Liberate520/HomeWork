package ru.gb.famaly_tree.view;

import ru.gb.famaly_tree.Main;
import ru.gb.famaly_tree.view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainMenu {
    private List<CommandAbstract> commandList;

    public MainMenu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
        commandList.add(new CommandAddCouple(consoleUI));
        commandList.add(new CommandCreateHuman(consoleUI));
        commandList.add(new CommandInfo(consoleUI));
        commandList.add(new CommandPrintFamalyTree(consoleUI));
        commandList.add(new CommandPrintHumanList(consoleUI));
        commandList.add(new CommandSortByAge(consoleUI));
        commandList.add(new CommandSortByChildrenCount(consoleUI));
        commandList.add(new CommandSortByName(consoleUI));
        commandList.add(new CommandSave(consoleUI));
        commandList.add(new CommandDownload(consoleUI));
        commandList.add(new CommandFinish(consoleUI));
    }

    public String outputMenuInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<commandList.size(); i++){
            stringBuilder.append((i+1) + " - ");
            stringBuilder.append(commandList.get(i).getDiscription() + "\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int i) throws IOException, ClassNotFoundException {
        CommandAbstract command = commandList.get(i-1);
        command.execute();
    }

    public Integer getSize(){
        return commandList.size();
    }
}