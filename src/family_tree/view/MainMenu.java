package family_TREE.view;

import family_TREE.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commands;
    public MainMenu(Console console) {
        commands = new ArrayList<>();
        commands.add(new Command(console));
        commands.add(new AddHuman(console));
        commands.add(new GetHumanList(console));
        commands.add(new SortByName(console));
        commands.add(new SortByDeathDate(console));
        commands.add(new Finish(console));
        }
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(String choice){
        commands.get(Integer.parseInt(choice) - 1).execute();
    }
}
