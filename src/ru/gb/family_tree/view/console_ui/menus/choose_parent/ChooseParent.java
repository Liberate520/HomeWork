package ru.gb.family_tree.view.console_ui.menus.choose_parent;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.view.console_ui.menus.Menu;
import ru.gb.family_tree.view.console_ui.menus.choose_parent.commands.ChooseParentCommand;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChooseParent implements Menu {
    private Parents parent;
    private List<ChooseParentCommand> commands;
    private ConsoleUi consoleUi;

    public ChooseParent(Parents parent, Map<String, Integer> fullNameId, ConsoleUi consoleUi) {
        this.parent = parent;
        this.consoleUi = consoleUi;
        createMenuItems(fullNameId);
    }

    private void createMenuItems(Map<String, Integer> fullNameId){
        commands = new ArrayList<>();
        if(fullNameId != null){
            for(Map.Entry<String, Integer> entry : fullNameId.entrySet()){
                commands.add(new ChooseParentCommand(consoleUi, entry.getKey(), entry.getValue(), parent));
            }
        }
    }

    @Override
    public String showMenu(){
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
            stringBuilder.append("0. Неизвестен");
            stringBuilder.append("\n");
        } else {
            stringBuilder.append("В семейном дереве не найдено ни одного подходящего человека!");
        }

        return stringBuilder.toString();
    }

    private void setParentAsNull(){
        if(parent == Parents.Mother){
            consoleUi.setInfoInCollector(null, CollectorItems.Mother);
        } else {
            consoleUi.setInfoInCollector(null, CollectorItems.Father);
        }
    }

    @Override
    public void execute(int choice){
        if(choice < 1){
            setParentAsNull();
        } else {
            Command command = commands.get(choice - 1);
            command.execute();
        }
    }

    @Override
    public int size(){
        return commands.size();
    }
}
