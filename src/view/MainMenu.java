package view;

import view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new ReadFromFile(consoleUI));
        commandList.add(new SaveToFile(consoleUI));
        commandList.add(new ShowTree(consoleUI));
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SortByByrthDate(consoleUI));
        commandList.add(new SortByDeathDate(consoleUI));
        commandList.add(new SetFather(consoleUI));
        commandList.add(new SetMother(consoleUI));
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

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
