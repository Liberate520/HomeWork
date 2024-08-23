package View;

import View.Commands.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;

    public Menu(ConsoleWork consoleWork) {
        commandList = new ArrayList<>();
        commandList.add(new AddMember(consoleWork));
        commandList.add(new SortByName(consoleWork));
        commandList.add(new SortByAge(consoleWork));
        commandList.add(new ShowFamilyTree(consoleWork));
        commandList.add(new SaveFamilyTree(consoleWork));
        commandList.add(new LoadFamilyTree(consoleWork));
        commandList.add(new CreateFamilyLinkCommand(consoleWork)); 
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
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
