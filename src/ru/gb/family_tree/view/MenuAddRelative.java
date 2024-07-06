package ru.gb.family_tree.view;

import java.util.ArrayList;
import java.util.Arrays;
import ru.gb.family_tree.view.commands.AddChild;
import ru.gb.family_tree.view.commands.AddParent;
import ru.gb.family_tree.view.commands.AddSibling;
import ru.gb.family_tree.view.commands.AddSpouse;
import ru.gb.family_tree.view.commands.ExitSubMenu;

public class MenuAddRelative extends Menu {

    public MenuAddRelative(ConsoleUI consoleUI) {
        super(consoleUI, new ArrayList<>(Arrays.asList(

                new AddChild(consoleUI),
                new AddParent(consoleUI),
                new AddSpouse(consoleUI),
                new AddSibling(consoleUI),
                new ExitSubMenu(consoleUI)                
        )));
    }
}