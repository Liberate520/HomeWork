package View.AllMenu;

import View.Commands.Adds.*;
import View.Commands.Command;
import View.Commands.Searches.getAllFamily;
import View.Commands.Searches.getAllIndices;
import View.Commands.Searches.getFullPerson;
import View.Commands.Searches.getPersonOnSurname;
import View.Commands.Sorts.sortByBirthday;
import View.Commands.Sorts.sortedByName;
import View.Commands.end;
import View.ConsoleUi;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    protected String discription;
    protected List<Command> commands;

    public MainMenu(ConsoleUi consoleUi) {
        this.discription = "Основное меню: \n";
        this.commands = new ArrayList<>();
        commands.add(new sortByBirthday(consoleUi));
        commands.add(new sortedByName(consoleUi));
        commands.add(new addPerson(consoleUi));
        commands.add(new addParent(consoleUi));
        commands.add(new addChield(consoleUi));
        commands.add(new addBirthday(consoleUi));
        commands.add(new addDeathDate(consoleUi));
        commands.add(new getPersonOnSurname(consoleUi));
        commands.add(new getFullPerson(consoleUi));
        commands.add(new getAllFamily(consoleUi));
        commands.add(new getAllIndices(consoleUi));
        commands.add(new end(consoleUi));
    }

    public String getMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(discription);
        for (int i = 0; i < commands.size(); i++)
            stringBuilder.append(i + " - " + commands.get(i).getDiscription());
        return stringBuilder.toString();

    }
    public void choice(int choice) {
        commands.get(choice).execute();
    }

}