package ru.gd.family_tree.view.commands;

import ru.gd.family_tree.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
        List<Commands> commandsList;

    public MainMenu(ConsoleUI consoleUI) {
        commandsList=new ArrayList<>();
        commandsList.add(new AddHuman(consoleUI));
        commandsList.add(new AddChild(consoleUI));
        commandsList.add(new AddFather(consoleUI));
        commandsList.add(new AddMother(consoleUI));
        commandsList.add(new AddSpouse (consoleUI));
        commandsList.add(new GetAge(consoleUI));
        commandsList.add(new GetFamiliTree(consoleUI));
        commandsList.add(new GetSiblings(consoleUI));
        commandsList.add(new PrintNameFamiliTree(consoleUI));
        commandsList.add(new SortByData(consoleUI));
        commandsList.add(new SortByName(consoleUI));
        commandsList.add(new End(consoleUI));
        commandsList.add(new Save(consoleUI));
        commandsList.add(new Read(consoleUI));


    }
    public String menu(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Выберете действия : \n");
        for (int i = 0; i < commandsList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandsList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choise){
        Commands commands = commandsList.get(choise - 1);
        commands.execute();
    }
    public int size(){
        return commandsList.size();
    }
}
