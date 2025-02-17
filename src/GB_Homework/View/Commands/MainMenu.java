package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    List<Commands> commandsList;

    public MainMenu(ConsoleUI consoleUI) {
        commandsList=new ArrayList<>();

        commandsList.add(new AddHuman(consoleUI));
        commandsList.add(new AddChild(consoleUI));
        commandsList.add(new AddParent(consoleUI, "father")); // Добавление отца
        commandsList.add(new AddParent(consoleUI, "mother")); // Добавление матери
        commandsList.add(new AddSpouse (consoleUI));
        commandsList.add(new GetAge(consoleUI));
        commandsList.add(new GetFamilyTree(consoleUI));
        commandsList.add(new GetSiblings(consoleUI));
        commandsList.add(new Save(consoleUI));
        commandsList.add(new Read(consoleUI));
        commandsList.add(new SortByData(consoleUI));
        commandsList.add(new SortByName(consoleUI));
        commandsList.add(new PrintNameFamilyTree(consoleUI));
        commandsList.add(new End(consoleUI));

    }
    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите действия : \n");
        for (int i = 0; i < commandsList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandsList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choice){
        Commands commands = commandsList.get(choice - 1);
        commands.execute();
    }
    public int size(){
        return commandsList.size();
    }
}