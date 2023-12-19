package view;

import view.commands.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AllHuman(consoleUI));
        commandList.add(new GetHumanFullInfo(consoleUI));
        commandList.add(new GetFamily(consoleUI));
        commandList.add(new GetFamilyTree(consoleUI));
        commandList.add(new HumanDeath(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByFamilyName(consoleUI));
        commandList.add(new SaveHumanList(consoleUI));
        commandList.add(new LoadHumanList(consoleUI));
        commandList.add(new Finish(consoleUI));

    }
    public String getMenu(){
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

    public int getSize() {return commandList.size();}
}
