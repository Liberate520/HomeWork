package view.menu;

import view.ConsoleUI;
import view.commands.*;

public class MainMenu extends Menu{

    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new GetFamilyTreeInfo(consoleUI));
        commandList.add(new SetDeathDate(consoleUI));
        commandList.add(new SetParent(consoleUI));
        commandList.add(new SetSpouse(consoleUI));
        commandList.add(new Read(consoleUI));
        commandList.add(new Save(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}
