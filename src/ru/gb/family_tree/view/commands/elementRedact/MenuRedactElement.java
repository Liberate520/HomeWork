package ru.gb.family_tree.view.commands.elementRedact;

import ru.gb.family_tree.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class MenuRedactElement {
    private List<Command> commands;

    public MenuRedactElement(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new createNewElement(consoleUI));
        commands.add(new findElement(consoleUI));
        commands.add(new deleteElement(consoleUI));
        commands.add(new addNewInfoAboutElement(consoleUI));
        commands.add(new showCurrentTree(consoleUI));
        commands.add(new ru.gb.family_tree.view.commands.elementRedact.backToMainMenu(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Раздел редактирования элементов:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choise){
        Command command = commands.get(choise - 1);
        command.execute();
    }

    public int size(){
        return commands.size();
    }
}
