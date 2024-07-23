package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUi consoleUi) {
        commands = new ArrayList<>();
        commands.add(new AddPerson(consoleUi));
        commands.add(new GetPersonListInfo(consoleUi));
        commands.add(new SortByAge(consoleUi));
        commands.add(new SortByName(consoleUi));
        commands.add(new Finish(consoleUi));

    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выбирете действие:\n");
        for (int i = 0; i< commands.size(); i++){
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public  void execute(int choice){
        Command command = commands.get(choice-1);
        command.execute();
    }
}
