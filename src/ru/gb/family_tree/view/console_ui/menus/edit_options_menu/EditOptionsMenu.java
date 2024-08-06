package ru.gb.family_tree.view.console_ui.menus.edit_options_menu;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.Menu;
import ru.gb.family_tree.view.console_ui.menus.command.Command;
import ru.gb.family_tree.view.console_ui.menus.edit_options_menu.commands.*;


import java.util.ArrayList;
import java.util.List;

public class EditOptionsMenu implements Menu {
    private List<Command> commands;
    private int id;
    private Human editedHuman;
    private ConsoleUi consoleUi;

    public EditOptionsMenu(ConsoleUi consoleUi, int id) {
        this.commands = new ArrayList<>();
        this.id = id;
        this.consoleUi = consoleUi;
        editedHuman = consoleUi.getHumanById(id);
        addMenuItems();
    }

    private void addMenuItems(){
        commands.add(new EditNameCommand(consoleUi, id));
        commands.add(new EditPatronymicCommand(consoleUi, id));
        commands.add(new EditSurnameCommand(consoleUi, id));
        commands.add(new EditPatronymicCommand(consoleUi, id));
        commands.add(new EditGenderCommand(consoleUi, id));
        commands.add(new EditFatherCommand(consoleUi, id));
        commands.add(new EditMotherCommand(consoleUi, id));
        commands.add(new EditProfessionCommand(consoleUi, id));
        commands.add(new EditNationalityCommand(consoleUi, id));
        commands.add(new EditDateOfBirthCommand(consoleUi, id));
        commands.add(new EditBirthPlaceCommand(consoleUi, id));
        commands.add(new EditDateOfDeathCommand(consoleUi, id));
        commands.add(new EditChildrenCommand(consoleUi, id));
        commands.add(new EditNotesCommand(consoleUi, id));
        commands.add(new EditApplyChanges(consoleUi, id));
    }

    @Override
    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Редактирование записи: ");
        stringBuilder.append(editedHuman.getName());
        stringBuilder.append(" ");
        stringBuilder.append(editedHuman.getPatronymic());
        stringBuilder.append(" ");
        stringBuilder.append(editedHuman.getSurname());
        stringBuilder.append(", ID: ");
        stringBuilder.append(editedHuman.getId());
        stringBuilder.append("\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    @Override
    public int size() {
        return commands.size();
    }
}