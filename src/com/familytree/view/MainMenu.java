package com.familytree.view;

import com.familytree.presenter.FamilyTreePresenter;
import com.familytree.view.commands.*;

public class MainMenu {
    private ConsoleUI consoleUI;
    private Command[] commands;

    public MainMenu(ConsoleUI consoleUI, FamilyTreePresenter familyTreePresenter) {
        this.consoleUI = consoleUI;
        commands = new Command[]{
                new AddHuman(consoleUI),
                new GetHumanListInfo(consoleUI),
                new SortByName(consoleUI),
                new SortByBirthDate(consoleUI),
                new Finish(consoleUI),
        };
    }

    public String menu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Выберите команду: \n");
        for (int i = 0; i < commands.length; i++) {
            sb.append(i+1).append(" "). append(commands[i].getDescription()).append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice) {
        if (choice >= 1 && choice <= commands.length) {
            commands[choice - 1].execute();
        } else {
            System.out.println("Неверный выбор");
        }
    }




}