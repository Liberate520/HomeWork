package ru.gb.family.view.menu;

import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.*;
import ru.gb.family.view.command.editTree.CommandChangeTree;
import ru.gb.family.view.command.editTree.CommandFinishEditTree;
import ru.gb.family.view.command.editTree.CommandAddItemTree;
import ru.gb.family.view.command.editTree.CommandPrintTree;

import java.util.ArrayList;
import java.util.List;

public class EditTreeMenu {
    private List<Command> commands;

    public EditTreeMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new CommandAddItemTree(consoleUI));
        commands.add(new CommandChangeTree(consoleUI));
        //commands.add(new CommandSortTree(consoleUI));
        //commands.add(new CommandSerchItemTree(consoleUI));
        commands.add(new CommandPrintTree(consoleUI));
        commands.add(new CommandFinishEditTree(consoleUI));
    }
    public String menu(){
        System.out.println("\n");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-=Меню работы с деревом=-\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(Integer.parseInt(String.valueOf(i+1)) +":"+commands.get(i).getName()+"\n");
        }
        stringBuilder.append("Выберите варианты действий:");
        return stringBuilder.toString();
    }
    public List<String> printEditTreeMenuCommand(){
        List<String> listCommand = new ArrayList<>();
        for (int i = 0; i < commands.size(); i++){
            listCommand.add(Integer.parseInt(String.valueOf(i+1)) +":"+commands.get(i).getName());
        }
        return listCommand;
    }
    public void run(int choice){
        Command command = commands.get(choice-1);
        command.run();
    };
}
