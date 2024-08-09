package ru.gb.family_tree.view.console_ui.menus.choose_children;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.view.console_ui.menus.Menu;
import ru.gb.family_tree.view.console_ui.menus.choose_children.commands.ChooseChildrenCommand;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChooseChildren implements Menu {
    private List<Command> commands;
    private ConsoleUi consoleUi;

    public ChooseChildren(Map<String, Integer> fullNameId, ConsoleUi consoleUi) {
        this.consoleUi = consoleUi;
        createMenuItems(fullNameId);
    }

    private void createMenuItems(Map<String, Integer> fullNameId) {
        commands = new ArrayList<>();
        if(fullNameId != null){
            for(Map.Entry<String, Integer> entry : fullNameId.entrySet()){
                commands.add(new ChooseChildrenCommand(consoleUi, entry.getKey(), entry.getValue()));
            }
        }
    }

    @Override
    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        if(!commands.isEmpty()){
            stringBuilder.append("Выберите человека:");
            stringBuilder.append("\n");
            for(int i = 0; i < commands.size(); i++){
                stringBuilder.append(i + 1);
                stringBuilder.append(". ");
                stringBuilder.append(commands.get(i).getDescription());
                stringBuilder.append("\n");
            }
        } else {
            stringBuilder.append("В семейном дереве не найдено ни одного подходящего человека!");
        }
        return stringBuilder.toString();
    }

    @Override
    public void execute(int choice) {
            if(choice > 0){
                Command command = commands.get(choice - 1);
                command.execute();
            }
    }

    @Override
    public int size() {
        return commands.size();
    }
}
