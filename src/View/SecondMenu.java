package View;

import Model.Human.Human;
import View.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class SecondMenu {
    List<Command> commandList;
    private ConsoleUI consoleUI;
    private Human creatureId;

    public SecondMenu(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
        commandList = new ArrayList<>();
        commandList.add(new printMother(consoleUI));
        commandList.add(new printFather(consoleUI));
        commandList.add(new printChildren(consoleUI));
        commandList.add(new getName(consoleUI));
        commandList.add(new getSisters(consoleUI));
        commandList.add(new getBrothers(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String SecondMenu(){
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
        if (command instanceof Finish) {
            command.execute();
        } else {
            command.execute(creatureId);
        }
    }

    public void setCreatureId(Human creatureId) {
        this.creatureId = creatureId;
    }

    public int getSize(){
        return commandList.size();
    }



}
