package src.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.View.Actions.Actions;
import src.View.Actions.AddHuman;
import src.View.Actions.AddInfo;
import src.View.Actions.AddParentOrChild;
import src.View.Actions.Finish;
import src.View.Actions.Load;
import src.View.Actions.PrintByName;
import src.View.Actions.PrintTree;
import src.View.Actions.Save;
import src.View.Actions.SortByBirthday;
import src.View.Actions.SortByChildren;
import src.View.Actions.SortByName;

public class MainMenu {
    private List<Actions> actions;

    public MainMenu(ConsoleUI consoleUI) throws SecurityException, IOException {
        actions = new ArrayList<>();
        actions.add(new AddHuman(consoleUI));
        actions.add(new PrintTree(consoleUI));
        actions.add(new PrintByName(consoleUI));
        actions.add(new AddInfo(consoleUI));
        actions.add(new AddParentOrChild(consoleUI));
        actions.add(new SortByName(consoleUI));
        actions.add(new SortByBirthday(consoleUI));
        actions.add(new SortByChildren(consoleUI));
        actions.add(new Save(consoleUI));
        actions.add(new Load(consoleUI));
        actions.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Выберите действие:").append("\n");
        for (int i = 0; i < actions.size(); i++) {
            sb.append(i + 1);
            sb.append(" - ");
            sb.append(actions.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void run(int choice) throws ClassNotFoundException, IOException {
        Actions action = actions.get(choice - 1);
        action.run();
    }
}
