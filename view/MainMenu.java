package view;

import java.util.ArrayList;
import java.util.List;

import view.commands.AddHuman;
import view.commands.Command;
import view.commands.Finish;
import view.commands.GetFamilyTreeInfo;
import view.commands.LoadFamilyTreeData;
import view.commands.SaveFamilyTreeData;
import view.commands.SortByAge;
import view.commands.SortByGender;
import view.commands.SortByName;
import view.commands.StartAddDataMenu;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new StartAddDataMenu(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByGender(consoleUI));
        commands.add(new GetFamilyTreeInfo(consoleUI));
        commands.add(new LoadFamilyTreeData(consoleUI));
        commands.add(new SaveFamilyTreeData(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder menu = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            menu.append(i + 1);
            menu.append(".");
            menu.append(commands.get(i).getDescription());
            menu.append("\n");
        }
        return menu.toString();
    }

    public int getSize() {
        return commands.size();
    }

    public void execute(int choice) {
        Command command = commands.get(choice);
        command.execute();
    }
}