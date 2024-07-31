package view;

import view.commands.*;
import view.commands.add.AddChild;
import view.commands.add.AddHuman;
import view.commands.fileOperations.OpenFileMenu;
import view.commands.get.GetHumanBirthDate;
import view.commands.get.GetHumansListInfo;
import view.commands.set.*;
import view.commands.sort.OpenSortMenu;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new SetMother(consoleUI));
        commands.add(new SetFather(consoleUI));
        commands.add(new AddChild(consoleUI));
        commands.add(new GetHumanBirthDate(consoleUI));
        commands.add(new SetDateOfDeath(consoleUI));
        commands.add(new GetHumansListInfo(consoleUI));
        commands.add(new SetWedding(consoleUI));
        commands.add(new SetDivorce(consoleUI));
        commands.add(new OpenSortMenu(consoleUI));
        commands.add(new OpenFileMenu(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nМеню:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }
}
