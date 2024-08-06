package ru.gb.family_tree.view.console_ui.menus.choose_children.commands;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

import java.util.ArrayList;
import java.util.List;

public class ChooseChildrenCommand extends Command {
    private final int id;
    private List<Human> children;

    public ChooseChildrenCommand(ConsoleUi consoleUi, String description, int id) {
        super(description, consoleUi);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void execute() {
        if(getConsoleUi().getInfoFromCollector(CollectorItems.Children) == null){
            children = new ArrayList<>();
        } else {
            children = (List<Human>) getConsoleUi().getInfoFromCollector(CollectorItems.Children);
        }
        children.add(getConsoleUi().getHumanById(id));
        getConsoleUi().setInfoInCollector(children, CollectorItems.Children);
    }
}
