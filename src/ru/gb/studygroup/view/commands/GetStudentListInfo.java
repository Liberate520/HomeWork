package ru.gb.studygroup.view.commands;

import ru.gb.studygroup.view.ConsoleUI;

public class GetStudentListInfo extends Command {

    public GetStudentListInfo(ConsoleUI consoleUI) {
        super("Показать список студентов", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getStudentListInfo();
    }

}
