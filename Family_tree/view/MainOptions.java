package Family_tree.view;

import java.util.ArrayList;
import java.util.List;

import Family_tree.view.commands.AddHuman;
import Family_tree.view.commands.Command;
import Family_tree.view.commands.Finish;
import Family_tree.view.commands.GetFamilyTreeMembers;
import Family_tree.view.commands.SetFather;
import Family_tree.view.commands.SetMother;
import Family_tree.view.commands.SetSpouse;
import Family_tree.view.commands.SortByAge;
import Family_tree.view.commands.SortByName;

public class MainOptions {
    private List<Command> commandList;

        public MainOptions(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new GetFamilyTreeMembers(consoleUI));
        commandList.add(new SetSpouse(consoleUI));
        commandList.add(new SetFather(consoleUI));
        commandList.add(new SetMother(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String options(){
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
