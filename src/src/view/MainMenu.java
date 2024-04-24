package src.view;

import java.util.ArrayList;
import java.util.List;

import src.view.commands.AddPerson;
import src.view.commands.Command;
import src.view.commands.Finish;
import src.view.commands.Kinship;
import src.view.commands.PrintList;
import src.view.commands.SortByAge;
import src.view.commands.SortByName;

public class MainMenu {
    List<Command> listCommand;

    public MainMenu(ConsoleUI consoleUI) {
        listCommand = new ArrayList<>();
        listCommand.add(new AddPerson(consoleUI));
        listCommand.add(new Kinship(consoleUI));
        listCommand.add(new SortByName(consoleUI));
        listCommand.add(new SortByAge(consoleUI));
        listCommand.add(new PrintList(consoleUI));
        listCommand.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder textMenu = new StringBuilder();
        for (int i = 0; i < listCommand.size(); i++) {
            textMenu.append(i + 1);
            textMenu.append(". ");
            textMenu.append(listCommand.get(i).getDescription());
            textMenu.append("\n");
        }
        return textMenu.toString();
    }

    public void execut(String inputUser) {

        int input = Integer.parseInt(inputUser);
        Command commands = listCommand.get(input - 1);
        commands.execute();
    }

    public int getSize() {
        int size = listCommand.size();
        return size;
    }

}
