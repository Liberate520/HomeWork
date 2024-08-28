package family_tree.view;

import family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI){
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new AddChild(consoleUI));
        commands.add(new AddParent(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new GetFamilyTreeInfo(consoleUI));
        commands.add(new LoadFromFile(consoleUI));
        commands.add(new SaveToFile(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список команд:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int getSize(){
        return commands.size();
    }
}
