package group.model.view;

import group.model.view.comands.addWedding;
import group.model.view.comands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Commands> commandsList;

    public Menu(ConsoleUI consoleUI) {
        commandsList = new ArrayList<>();
        commandsList.add(new addHuman(consoleUI));
        commandsList.add(new addWedding(consoleUI));
        commandsList.add(new getHumansListInfo(consoleUI));
        commandsList.add(new sortByName(consoleUI));
        commandsList.add(new sortByDeathDate(consoleUI));
        commandsList.add(new Finish(consoleUI));


    }



    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandsList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandsList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Commands command = commandsList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandsList.size();
    }

}
