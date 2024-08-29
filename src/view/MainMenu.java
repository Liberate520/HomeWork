package view;

import view.commands.Add;
import view.commands.Command;
import view.commands.FindByName;
import view.commands.Finish;
import view.commands.GetFamilyTreeInfo;
import view.commands.Load;
import view.commands.Save;
import view.commands.SetBirthDate;
import view.commands.SetDeathDate;
import view.commands.SetParents;
import view.commands.SortByAge;
import view.commands.SortByBirthDate;
import view.commands.SortByName;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(View ui) {
        commandList = new ArrayList<>();
        commandList.add(new Save(ui));
        commandList.add(new Load(ui));
        commandList.add(new Add(ui));
        commandList.add(new GetFamilyTreeInfo(ui));
        commandList.add(new SetBirthDate(ui));
        commandList.add(new SetDeathDate(ui));
        commandList.add(new SetParents(ui));
        commandList.add(new FindByName(ui));
        commandList.add(new SortByName(ui));
        commandList.add(new SortByBirthDate(ui));
        commandList.add(new SortByAge(ui));
        commandList.add(new Finish(ui));
    }

    public List<String> getMenu() {
        List<String> menu = new ArrayList<>();
        for (Command command : commandList) {
            menu.add(command.getDescription());
        }
        return menu;
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }

}
