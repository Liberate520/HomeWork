package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new CreateDefaultFamilyTree(consoleUI));
        commands.add(new ReadFromFile(consoleUI));
        commands.add(new AddHuman(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByBirthDate(consoleUI));
        commands.add(new GetHumanListInfo(consoleUI));
        commands.add(new SaveToFile(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Commands:\n");
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
