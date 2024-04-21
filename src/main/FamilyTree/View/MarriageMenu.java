package FamilyTree.View;


import FamilyTree.View.Commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarriageMenu {

    private List<Commands> menu;

    public MarriageMenu(ConsoleUI consoleUI) {
        menu = new ArrayList<>();
        menu.add(new MarriageForINN(consoleUI));
        menu.add(new MarriageNewPartner(consoleUI));

    }

    public String printMenu() {
        StringBuilder stringMenu = new StringBuilder();
        stringMenu.append("Меню:\n");
        for (int i = 0; i < menu.size(); i++) {
            stringMenu.append(i + 1);
            stringMenu.append(". ");
            stringMenu.append(menu.get(i).getDescription());
            stringMenu.append("\n");
        }
        return stringMenu.toString();


    }

    public void execute(int choice) throws IOException {
        Commands command = menu.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return menu.size();
    }
}
