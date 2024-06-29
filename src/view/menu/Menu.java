package view.menu;

import view.ConsoleUI;
import view.commands.Command;

import java.util.List;
import java.util.ArrayList;

public class Menu {
    List<Command> commandList;

    public Menu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
    }

    public String menu(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i +1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }


    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
