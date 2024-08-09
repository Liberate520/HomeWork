package ru.gb.family_tree.view.console_ui.menus.choose_gender;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.Menu;
import ru.gb.family_tree.view.console_ui.menus.choose_gender.commands.ChooseMan;
import ru.gb.family_tree.view.console_ui.menus.choose_gender.commands.ChooseWoman;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

import java.util.ArrayList;
import java.util.List;

public class ChooseGender implements Menu {
    List<Command> commands;

    public ChooseGender(ConsoleUi consoleUi) {
        commands = new ArrayList<>();
        commands.add(new ChooseMan(consoleUi));
        commands.add(new ChooseWoman(consoleUi));
    }

    @Override
    public String showMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите пол:");
        stringBuilder.append("\n");
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
