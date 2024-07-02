package seminar2.View.commands;

import seminar2.View.commands.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddRelative(consoleUI));
        commands.add(new GetByOneFamily(consoleUI));
        commands.add(new GetRelativeByNameSurname(consoleUI));
        commands.add(new GetTreeInfo(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortBySurname(consoleUI));
        commands.add(new Finish(consoleUI));
        commands.add(new Save(consoleUI));
        commands.add(new Load(consoleUI));

    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню: \n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size(){
        return commands.size();
    }
}
