package view;

import view.commands.Command;
import view.commands.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;
    public MainMenu(ConsoleUI consoleUI){
        commands = new ArrayList<>();

        commands.add(new Finish(consoleUI));
        commands.add(new AddHuman(consoleUI));
        commands.add(new GetHumanListInfo(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByLastName(consoleUI));
        commands.add(new SortByAge(consoleUI));
    }
    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню:\n");
        for(int i = 1; i < commands.size(); i++){
            stringBuilder.append(i);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.append(0 + ". " + commands.get(0).getDescription() + "\n");
        return stringBuilder.toString();
    }
    public void execute(int choice){
        Command command = commands.get(choice);
        command.execute();
    }
    public int size(){
        return commands.size();
    }
}
