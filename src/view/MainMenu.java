package view;

import view.commands.*;
import view.commands.basemenu.*;
import view.commands.familyTies.AddChild;
import view.commands.familyTies.FamilyTies;
import view.commands.familyTies.SetFather;
import view.commands.familyTies.SetMother;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;
    private FamilyTiesMenu fmenu;

    public MainMenu(ConsoleUi consoleUi) {
        fmenu = new FamilyTiesMenu(consoleUi);
        commands = new ArrayList<>();
        commands.add(new AddPerson(consoleUi));
        commands.add(new FamilyTies(consoleUi));
        commands.add(new GetPersonListInfo(consoleUi));
        commands.add(new SortByName(consoleUi));
        commands.add(new SortByAge(consoleUi));
        commands.add(new ReadTree(consoleUi));
        commands.add(new WriteTree(consoleUi));
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
        try {
            command.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FamilyTiesMenu getFmenu() {
        return fmenu;
    }
}
