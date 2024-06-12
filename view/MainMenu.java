package OOP.SemDZ.homeWork.view;

import java.util.ArrayList;
import java.util.List;

import OOP.SemDZ.homeWork.view.commands.*;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new PrintFamilyTree(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SaveToFile(consoleUI));
        commandList.add(new LoadOfFile(consoleUI));
        commandList.add(new Wedding(consoleUI));
        commandList.add(new BirthChildren(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menuPrint(){
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
