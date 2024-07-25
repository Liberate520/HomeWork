package view;

import view.commands.Command;
import view.commands.ToBaseMenu;
import view.commands.basemenu.*;
import view.commands.familyTies.AddChild;
import view.commands.familyTies.FamilyTies;
import view.commands.familyTies.SetFather;
import view.commands.familyTies.SetMother;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FamilyTiesMenu {
    private List<Command> commands;

    public FamilyTiesMenu(ConsoleUi consoleUi) {
        commands = new ArrayList<>();
        commands.add(new SetMother(consoleUi));
        commands.add(new SetFather(consoleUi));
        commands.add(new AddChild(consoleUi));
        commands.add(new ToBaseMenu(consoleUi));
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
}
