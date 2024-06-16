package ru.gb.family_tree.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.gb.family_tree.view.commands.AddFamilyTreeItem;
import ru.gb.family_tree.view.commands.Command;
import ru.gb.family_tree.view.commands.ExitProgram;
import ru.gb.family_tree.view.commands.GetTreeInfo;
import ru.gb.family_tree.view.commands.LoadTree;
import ru.gb.family_tree.view.commands.SaveTree;
import ru.gb.family_tree.view.commands.SortByAge;
import ru.gb.family_tree.view.commands.SortByName;
import ru.gb.family_tree.view.commands.SortBySpouse;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(@SuppressWarnings("rawtypes") ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new LoadTree(consoleUI));        
        commandList.add(new AddFamilyTreeItem(consoleUI));
        commandList.add(new GetTreeInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SortBySpouse(consoleUI)); 
        commandList.add(new SaveTree(consoleUI));                   
        commandList.add(new ExitProgram(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws FileNotFoundException, ClassNotFoundException, IOException {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }
}