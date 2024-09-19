package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class FindHumanByName extends Command{

    public FindHumanByName(ConsoleUI consoleUI){
        super("Найти члена семьи по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().findHumanByName();
    }
}