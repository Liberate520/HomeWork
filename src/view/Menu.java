package view;
import view.commands.*;
import view.commands.Command.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;

    public Menu(ConsoleUi consoleUi) {
        commandList = new ArrayList<>();
        commandList.add(new PrintTreeInfo(consoleUi));
        commandList.add((new AddHuman(consoleUi)));
        commandList.add(new FindHuman(consoleUi));
        commandList.add(new SetDeathDay(consoleUi));
        commandList.add(new RemoveHuman(consoleUi));
        commandList.add(new SetWedding(consoleUi));
        commandList.add(new SetDivorce(consoleUi));
        commandList.add(new SetChild(consoleUi));
        commandList.add(new SetParent(consoleUi));
        commandList.add(new SaveTree(consoleUi));
        commandList.add(new LoadTree(consoleUi));
        commandList.add(new SortById(consoleUi));
        commandList.add(new SortByName(consoleUi));
        commandList.add(new SortByAge(consoleUi));
        commandList.add(new Finish(consoleUi));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
