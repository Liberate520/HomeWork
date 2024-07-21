package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class FamilyMenu {
    private final List<Commands> commands;

    public FamilyMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new GetHumanListInfo(consoleUI));
        commands.add(new SortByGender(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new StopProgram(consoleUI));
    }

    public String familyMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Меню семейного древа:\n");
        for (int i = 0; i < commands.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commands.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice) {
        Commands command = commands.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }
}
