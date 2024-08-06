package ru.gb.family_tree.view.console_ui.menus.main_menu;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.Menu;
import ru.gb.family_tree.view.console_ui.menus.command.Command;
import ru.gb.family_tree.view.console_ui.menus.edit_menu.EditMenu;
import ru.gb.family_tree.view.console_ui.menus.main_menu.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Menu {
    private List<Command> commands;

    public MainMenu(ConsoleUi consoleUi) {
        this.commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUi));
        commands.add(new EditHuman(consoleUi));
        commands.add(new ShowFamilyTree(consoleUi));
        commands.add(new SearchHumans(consoleUi));
        commands.add(new SortByName(consoleUi));
        commands.add(new SortByAge(consoleUi));
        commands.add(new SortByBirthday(consoleUi));
        commands.add(new SortByID(consoleUi));
        commands.add(new SaveToFile(consoleUi));
        commands.add(new LoadFromFile(consoleUi));
        commands.add(new ExitProgram(consoleUi));
    }

    @Override
    public String showMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Главное меню\n");
        for(int i = 0; i < commands.size(); i++){
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public void execute(int choice){
        Command command = commands.get(choice - 1);
        command.execute();
    }

    @Override
    public int size(){
        return commands.size();
    }
}
