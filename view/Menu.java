package homeWork.view;

import java.util.ArrayList;
import java.util.List;

import homeWork.view.command.AddHuman;
import homeWork.view.command.Command;
import homeWork.view.command.Finish;
import homeWork.view.command.GetTreeList;
import homeWork.view.command.LoadTreeFromFile;
import homeWork.view.command.SaveTreeToFile;
import homeWork.view.command.SortbyDate;
import homeWork.view.command.SortbyName;

public class Menu {
    private List<Command> commands;

    public Menu(Console console){
        commands = new ArrayList<>();
        commands.add(new AddHuman(console));
        commands.add(new GetTreeList(console));
        commands.add(new SortbyDate(console));
        commands.add(new SortbyName(console));
        commands.add(new LoadTreeFromFile(console));
        commands.add(new SaveTreeToFile(console));
        commands.add(new Finish(console));
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int index){
        Command command = commands.get(index-1);
        command.execute();
    }
}
