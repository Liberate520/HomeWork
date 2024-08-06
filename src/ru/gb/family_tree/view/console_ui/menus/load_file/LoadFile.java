package ru.gb.family_tree.view.console_ui.menus.load_file;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.Menu;
import ru.gb.family_tree.view.console_ui.menus.command.Command;
import ru.gb.family_tree.view.console_ui.menus.load_file.commands.LoadFileCommand;

import java.util.ArrayList;
import java.util.List;

public class LoadFile implements Menu {
    List<Command> commands;
    ConsoleUi consoleUi;

    public LoadFile(List<String> fileList, ConsoleUi consoleUi) {
        commands = new ArrayList<>();
        this.consoleUi = consoleUi;
        createMenuItems(fileList);
    }

    private void createMenuItems(List<String> fileList){
        for (String fileName : fileList){
            commands.add(new LoadFileCommand(fileName, consoleUi));
        }
    }

    @Override
    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        if(!commands.isEmpty()){
            stringBuilder.append("Выберите файл для загрузки:");
            stringBuilder.append("\n");
            for(int i = 0; i < commands.size(); i++){
                stringBuilder.append(i + 1);
                stringBuilder.append(". ");
                stringBuilder.append(commands.get(i).getDescription());
                stringBuilder.append("\n");
            }
        } else {
            stringBuilder.append("Файлы не найдены!");
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
