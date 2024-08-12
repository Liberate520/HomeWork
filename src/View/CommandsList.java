package View;

import View.Commands.Common.PrintCommands;
import View.Commands.ForDatabase.CreateFamilyTree;
import View.Commands.Command;
import View.Commands.ForDatabase.ExitFromApp;
import View.Commands.ForDatabase.OpenSave;
import View.Commands.ForDatabase.PrintSaves;
import View.Commands.ForFamilyTree.*;

import java.util.ArrayList;

public class CommandsList {
    private final ArrayList<Command> databaseCommands = new ArrayList<>();
    private final ArrayList<Command> familyTreeCommands = new ArrayList<>();

    public CommandsList(ConsoleUI consoleUI){
        this.databaseCommands.add(new ExitFromApp(consoleUI));
        this.databaseCommands.add(new CreateFamilyTree(consoleUI));
        this.databaseCommands.add(new OpenSave(consoleUI));
        this.databaseCommands.add(new PrintSaves(consoleUI));
        this.databaseCommands.add(new PrintCommands(consoleUI));

        this.familyTreeCommands.add(new ExitFromFamilyTree(consoleUI));
        this.familyTreeCommands.add(new SaveTree(consoleUI));
        this.familyTreeCommands.add(new PrintFileName(consoleUI));
        this.familyTreeCommands.add(new PrintDescription(consoleUI));
        this.familyTreeCommands.add(new AddEntity(consoleUI));
        this.familyTreeCommands.add(new PrintFamilyTree(consoleUI));
        this.familyTreeCommands.add(new PrintEntity(consoleUI));
        this.familyTreeCommands.add(new FindEntity(consoleUI));
        this.familyTreeCommands.add(new RemoveEntity(consoleUI));
        this.familyTreeCommands.add(new SetName(consoleUI));
        this.familyTreeCommands.add(new SetSurname(consoleUI));
        this.familyTreeCommands.add(new SetGender(consoleUI));
        this.familyTreeCommands.add(new SetDateOfBirth(consoleUI));
        this.familyTreeCommands.add(new SetDateOfDeath(consoleUI));
        this.familyTreeCommands.add(new SetSpouse(consoleUI));
        this.familyTreeCommands.add(new SetMather(consoleUI));
        this.familyTreeCommands.add(new SetFather(consoleUI));
        this.familyTreeCommands.add(new AddKid(consoleUI));
        this.familyTreeCommands.add(new SortByName(consoleUI));
        this.familyTreeCommands.add(new SortByChildren(consoleUI));
        this.familyTreeCommands.add(new SortByID(consoleUI));
        this.familyTreeCommands.add(new SetFileName(consoleUI));
        this.familyTreeCommands.add(new SetDescription(consoleUI));
        this.familyTreeCommands.add(new PrintCommands(consoleUI));
    }

    public ArrayList<Command> getDatabaseCommands() {
        return databaseCommands;
    }

    public ArrayList<Command> getFamilyTreeCommands() {
        return familyTreeCommands;
    }
}
