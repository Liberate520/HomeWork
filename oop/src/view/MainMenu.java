package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddLivingItem(consoleUI));
        commandList.add(new AddDeathItem(consoleUI));
        commandList.add(new AddItemWithParent(consoleUI));
        commandList.add(new GetFamilytreeInfo(consoleUI));
        commandList.add(new AddChildById(consoleUI));
        commandList.add(new AddParentById(consoleUI));
        commandList.add(new GetByName(consoleUI));
        commandList.add(new GetInfoManForId(consoleUI));
        commandList.add(new GetParentById(consoleUI));
        commandList.add(new GetChildrensById(consoleUI));
        commandList.add(new RemoveById(consoleUI));
        commandList.add(new SetWeddingById(consoleUI));
        commandList.add(new SetDivorceById(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SaveTree(consoleUI));
        commandList.add(new LoadTree(consoleUI));
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

