package ru.gb.family_tree.view.console_ui.menus.edit_options_menu.commands;

import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EditChildrenCommand extends Command {
    private int id;
    Human editedHuman;
    List<Human> children;
    public EditChildrenCommand(ConsoleUi consoleUi, int id) {
        super("Редактировать детей", consoleUi);
        this.id = id;
        editedHuman = getConsoleUi().getHumanById(id);

//        (LocalDate) infoCollector.getCollectorItem(CollectorItems.DateOfBirth)
//                (LocalDate) infoCollector.getCollectorItem(CollectorItems.DateOfDeath)
    }

    private void setDatesToCollector(){
        if(getConsoleUi().getInfoFromCollector(CollectorItems.DateOfBirth) == null){
            getConsoleUi().setInfoInCollector((Object) editedHuman.getDateOfBirthday(), CollectorItems.DateOfBirth);
        }
        if(getConsoleUi().getInfoFromCollector(CollectorItems.DateOfDeath) == null){
            getConsoleUi().setInfoInCollector((Object) editedHuman.getDateOfDeath(), CollectorItems.DateOfDeath);
        }
    }

    @Override
    public void execute() {
        setDatesToCollector();
        if(editedHuman.getChildren() != null){
            if(getConsoleUi().yesNoQuestion("Очистить список детей?")){
                children = null;
            } else {
                children = editedHuman.getChildren();
            }
        }
        getConsoleUi().setInfoInCollector((Object) children, CollectorItems.Children);
        getConsoleUi().addChildren();
    }

}



