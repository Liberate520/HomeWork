package ru.gb.studygroup.view;

import ru.gb.studygroup.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddStudent(consoleUI));
        commands.add(new GetStudentListInfo(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String getMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список команд:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choose) {
        Command command = commands.get(choose - 1);
        command.execute();
    }

    public int sizeMenu() {
        return commands.size();
    }
}
