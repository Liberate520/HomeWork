package ru.gb.family_tree.view.console_ui.menus.edit_menu;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.Menu;
import ru.gb.family_tree.view.console_ui.menus.command.Command;
import ru.gb.family_tree.view.console_ui.menus.edit_menu.commands.EditMenuCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EditMenu implements Menu {
    private ConsoleUi consoleUi;
    private List<Command> commands;

    public EditMenu(Map<String, Integer> editMenuItems, ConsoleUi ui) {
        this.consoleUi = ui;
        commands = new ArrayList<>();
        generateMenuItems(editMenuItems);
    }

    private void generateMenuItems(Map<String, Integer> editMenuItems){
        for(Map.Entry<String, Integer> entry : editMenuItems.entrySet()){
            commands.add(new EditMenuCommand(entry.getKey(), consoleUi, entry.getValue()));
        }
    }

    @Override
    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        if(!commands.isEmpty()){
            stringBuilder.append("Выберите запись для редактирования:");
            stringBuilder.append("\n");
            for(int i = 0; i < commands.size(); i++){
                stringBuilder.append(i + 1);
                stringBuilder.append(". ");
                stringBuilder.append(commands.get(i).getDescription());
                stringBuilder.append("\n");
            }
        } else {
            stringBuilder.append("В дереве нет записей для редактирования!");
            stringBuilder.append("\n");
            stringBuilder.append("Нажмите Enter...");
        }
        return stringBuilder.toString();
    }

    @Override
    public void execute(int choice) {
        if(choice > 0){
            Command command = commands.get(choice - 1);
            command.execute();
        } else {
            consoleUi.mainMenu();
        }
    }

    @Override
    public int size() {
        return commands.size();
    }
}
