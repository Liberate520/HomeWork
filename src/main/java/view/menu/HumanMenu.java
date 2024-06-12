package view.menu;

import view.ConsoleUI;
import view.commands.Command;
import view.commands.Finish;
import view.commands.LoadTree;
import view.commands.SaveTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HumanMenu extends AbstractMenu implements Menu {

    public HumanMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new LoadTree(consoleUI));
        commandList.add(new SaveTree(consoleUI));
        commandList.add(new Finish(consoleUI));

    }
}
