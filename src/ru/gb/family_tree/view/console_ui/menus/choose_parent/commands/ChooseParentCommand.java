package ru.gb.family_tree.view.console_ui.menus.choose_parent.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.view.console_ui.menus.choose_parent.Parents;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class ChooseParentCommand extends Command {
    private final int id;
    private final Parents parent;

    public ChooseParentCommand(ConsoleUi consoleUi, String description, int id, Parents parent) {
        super(description, consoleUi);
        this.id = id;
        this.parent = parent;
    }


    public int getId() {
        return id;
    }

    public void execute() {
        Object data = (Object)getConsoleUi().getHumanById(id);
        if(parent == Parents.Mother){
            getConsoleUi().setInfoInCollector(data, CollectorItems.Mother);
        } else {
            getConsoleUi().setInfoInCollector(data, CollectorItems.Father);
        }

    }
}
