package family_tree.view.consoleUI;

import family_tree.view.consoleUI.commandsConsole.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> menu;

    public MainMenu(ConsoleUI consoleUI) {
        menu = new ArrayList<>();
        menu.add(new ShowTree(consoleUI));
        menu.add(new AddHuman(consoleUI));
        menu.add(new AddFamilyLink(consoleUI));
        menu.add(new RegisterDeath(consoleUI));
        menu.add(new FindByDocument(consoleUI));
        menu.add(new FindByName(consoleUI));
        menu.add(new SortByName(consoleUI));
        menu.add(new SortByBirthDate(consoleUI));
        menu.add(new SaveDataFile(consoleUI));
        menu.add(new Exit(consoleUI));
    }

    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append("Выберите действие:");
        stringBuilder.append("\n");
        for (int i = 0; i < menu.size(); i++) {
            stringBuilder.append(i +1);
            stringBuilder.append(". ");
            stringBuilder.append(menu.get(i).getCommandName());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = menu.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return menu.size();
    }
}
