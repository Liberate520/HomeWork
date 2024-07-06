package ru.gb.family_tree.view;

import java.util.ArrayList;
import java.util.Arrays;
import ru.gb.family_tree.view.commands.AddFamilyTreeItem;
import ru.gb.family_tree.view.commands.AddRelative;
import ru.gb.family_tree.view.commands.Finish;
import ru.gb.family_tree.view.commands.GetTreeInfo;
import ru.gb.family_tree.view.commands.LoadTree;
import ru.gb.family_tree.view.commands.SaveTree;
import ru.gb.family_tree.view.commands.SortByAge;
import ru.gb.family_tree.view.commands.SortById;
import ru.gb.family_tree.view.commands.SortByName;
import ru.gb.family_tree.view.commands.SortBySpouse;

public class MenuMain extends Menu {

    public MenuMain(ConsoleUI consoleUI) {
        super(consoleUI, new ArrayList<>(Arrays.asList(

                new LoadTree(consoleUI),
                new AddFamilyTreeItem(consoleUI),
                new AddRelative(consoleUI),                
                new GetTreeInfo(consoleUI),
                new SortById(consoleUI),
                new SortByName(consoleUI),
                new SortByAge(consoleUI),
                new SortBySpouse(consoleUI),
                new SaveTree(consoleUI),
                new Finish(consoleUI)

        )));
    }
}