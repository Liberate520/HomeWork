package View;

import View.Commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
        commandList.add(new addCreature(consoleUI));
        commandList.add(new printFamilyTree(consoleUI));
        commandList.add(new sortByChildrenAmount(consoleUI));
        commandList.add(new sortByAge(consoleUI));
        commandList.add(new sortByName(consoleUI));
        commandList.add(new getInfo(consoleUI));
        commandList.add(new addMother(consoleUI));
        commandList.add(new addFather(consoleUI));
        commandList.add(new removeMother(consoleUI));
        commandList.add(new removeFather(consoleUI));
        commandList.add(new addChild(consoleUI));
        commandList.add(new removeChild(consoleUI));
        commandList.add(new setSpouse(consoleUI));
        commandList.add(new setDivorce(consoleUI));
        commandList.add(new writeObjectToFile(consoleUI));
        commandList.add(new recoverObjectFromFile(consoleUI));
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

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}