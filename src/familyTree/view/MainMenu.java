package familyTree.view;

import familyTree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByID(consoleUI));
        commands.add(new AddParent(consoleUI));
        commands.add(new AddChild(consoleUI));
        commands.add(new GetFamilyTree(consoleUI));
        commands.add(new SaveTree(consoleUI));
        commands.add(new LoadTree(consoleUI));
        commands.add(new Finish(consoleUI));

    }

    public String menuInfo(){
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Список команд: \n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1).append(". ").append(commands.get(i).getDescription()).append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute (int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int menuSize() {
        return commands.size();
    }
}
