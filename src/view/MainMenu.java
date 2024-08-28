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

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new Save(consoleUI));
        commandList.add(new Load(consoleUI));
        commandList.add(new Add(consoleUI));
        commandList.add(new GetFamilyTreeInfo(consoleUI));
        commandList.add(new SetBirthDate(consoleUI));
        commandList.add(new SetDeathDate(consoleUI));
        commandList.add(new SetParents(consoleUI));
        commandList.add(new FindByName(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByBirthDate(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String getMenu() {
        StringBuilder stringBuilder = new StringBuilder("\nГлавное меню\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder
                    .append(i + 1)
                    .append(". ")
                    .append(commandList.get(i).getDescription())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }

}
