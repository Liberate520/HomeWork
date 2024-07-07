package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private List<Commands> commandsList;

    public MainMenu(ConsoleUI consoleUI){
        commandsList = new ArrayList<>();
        commandsList.add(new GetFullTree(consoleUI));
        commandsList.add(new AddMember(consoleUI));
        commandsList.add(new WriteFile(consoleUI));
        commandsList.add(new ReadFile(consoleUI));
    }

    public String menu(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandsList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandsList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }
    public void execute(int choice) throws IOException, ClassNotFoundException {
        Commands command = commandsList.get(choice-1);
        command.execute();
    }
    public int getSize(){
        return commandsList.size();
    }
}
