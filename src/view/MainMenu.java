package view;

import view.allcommands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private List<Command> allCommandList;
    public MainMenu(ConsoleUI consoleUI) {
        allCommandList = new ArrayList<>();
        allCommandList.add(new AddFamilyMember(consoleUI));
        allCommandList.add(new AddKinship(consoleUI));
        allCommandList.add(new ShowTree(consoleUI));
        allCommandList.add(new SortByName(consoleUI));
        allCommandList.add(new SortByDateOfBirth(consoleUI));
        allCommandList.add(new SaveTree(consoleUI));
        allCommandList.add(new PrintLoadedTree(consoleUI));
        allCommandList.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < allCommandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(allCommandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = allCommandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return allCommandList.size();
    }


}
