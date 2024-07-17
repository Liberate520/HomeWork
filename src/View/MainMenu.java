package View;

import java.util.ArrayList;
import java.util.List;

import View.Commands.*;

public class MainMenu {
    List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();

        commands.add(new AddStudent(consoleUI));
        commands.add(new GetTree(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByBrthDate(consoleUI));
        commands.add(new SortById(consoleUI));
        commands.add(new Save(consoleUI));
        commands.add(new Load(consoleUI));
        commands.add(new SetSex(consoleUI));
        commands.add(new SetFamily(consoleUI));
        commands.add(new SetSpouse(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescripton());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choise) {
        Command command = commands.get(choise - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }


}
