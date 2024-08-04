package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class FamConnectMenu {
    private List<Command> commands;

    public FamConnectMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new WeddingCommand(consoleUI));
        commands.add(new AddChildCommand(consoleUI));
        commands.add(new AddParentsCommand(consoleUI));
        commands.add(new BackToMainMenuCommand(consoleUI));
        commands.add(new FinishCommand(consoleUI));
    }

    public String showFamConnectMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню семейных связей: \n");
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
