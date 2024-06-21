package ru.gb.family.view.menu;

import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;


import ru.gb.family.view.command.editItemTree.CommandAddParent;
import ru.gb.family.view.command.editItemTree.CommandEditItemAddCildren;
import ru.gb.family.view.command.editItemTree.CommandFinishEditItemTree;

import java.util.ArrayList;
import java.util.List;

public class EditItemTreeMenu {
    private List<Command> commands;

    public EditItemTreeMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new CommandAddParent(consoleUI));
        commands.add(new CommandEditItemAddCildren(consoleUI));
        //commands.add(new CommandSerchItemTree(consoleUI));
        //commands.add(new CommandPrintTree(consoleUI));
        commands.add(new CommandFinishEditItemTree(consoleUI));
    }

    public String menu() {
        System.out.println("\n");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-=Меню редактирование конкретного экземляра Семейного дерева=-\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(Integer.parseInt(String.valueOf(i + 1)) + ":" + commands.get(i).getName() + "\n");
        }
        stringBuilder.append("Выберите варианты действий:");
        return stringBuilder.toString();
    }
    public List<String> printEditItemTreeMenuCommand(){
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
