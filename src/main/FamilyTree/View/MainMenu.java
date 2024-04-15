package FamilyTree.View;


import FamilyTree.View.Commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private List<Commands> mainMenu;

    public MainMenu(ConsoleUI consoleUI) {
        mainMenu = new ArrayList<>();
        mainMenu.add(new BeginFamilyTree(consoleUI));
        mainMenu.add(new PrintTree(consoleUI));
        mainMenu.add(new EstablishParent(consoleUI));
        mainMenu.add(new EstablishMarriage(consoleUI));
        mainMenu.add(new SortByName(consoleUI));
        mainMenu.add(new SortByAge(consoleUI));
        mainMenu.add(new ReadToFile(consoleUI));
        mainMenu.add(new SaveToFile(consoleUI));
        mainMenu.add(new Finish(consoleUI));
    }

    public String printMenu() {
        StringBuilder stringMenu = new StringBuilder();
        stringMenu.append("Меню:\n");
        for (int i = 0; i < mainMenu.size(); i++) {
            stringMenu.append(i + 1);
            stringMenu.append(". ");
            stringMenu.append(mainMenu.get(i).getDescription());
            stringMenu.append("\n");
        }
        return stringMenu.toString();


    }

    public void execute(int choice) throws IOException {
        Commands command = mainMenu.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return mainMenu.size();
    }
}
