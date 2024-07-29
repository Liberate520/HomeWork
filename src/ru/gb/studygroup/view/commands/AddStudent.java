package ru.gb.studygroup.view.commands;

import ru.gb.studygroup.view.ConsoleUI;

public class AddStudent extends Command {

    public AddStudent(ConsoleUI consoleUI) {
        super("Добавить студента", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addStudent();
    }

}
