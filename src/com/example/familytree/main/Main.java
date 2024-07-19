package com.example.familytree.main;

import com.example.familytree.commands.*;
import com.example.familytree.mvp.FamilyTreePresenterImpl;
import com.example.familytree.mvp.ConsoleFamilyTreeView;
import com.example.familytree.operations.FileFamilyTreeOperations;
import com.example.familytree.operations.FileOperations;

public class Main {
    public static void main(String[] args) {
        ConsoleFamilyTreeView view = new ConsoleFamilyTreeView();
        FileOperations fileOps = new FileFamilyTreeOperations();


        FamilyTreePresenterImpl presenter = new FamilyTreePresenterImpl(view, fileOps);
        CommandHandler commandHandler = new CommandHandler(presenter, view);

        commandHandler.registerCommand(1, new AddPersonCommand(presenter, view));
        commandHandler.registerCommand(2, new SortByNameCommand(presenter));
        commandHandler.registerCommand(3, new SortByBirthDateCommand(presenter));
        commandHandler.registerCommand(4, new DisplayTreeCommand(presenter));
        commandHandler.registerCommand(5, new SaveTreeToFileCommand(presenter, view));
        commandHandler.registerCommand(6, new LoadTreeFromFileCommand(presenter, view));
        commandHandler.registerCommand(7, new RemovePersonCommand(presenter, view));
        commandHandler.registerCommand(8, new ChangePersonIdCommand(presenter, view));
        commandHandler.registerCommand(9, new SetParentChildRelationCommand(presenter, view));


        commandHandler.handleCommands();
    }
}
