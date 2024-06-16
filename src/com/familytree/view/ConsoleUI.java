
package com.familytree.view;

import com.familytree.model.family_tree.FamilyTreeModel;
import com.familytree.presenter.FamilyTreePresenter;
import com.familytree.view.commands.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;
    private FamilyTreePresenter presenter;
    private boolean work;
    private List<Command> commands;

    public ConsoleUI(FamilyTreeModel model) {
        this.presenter = new FamilyTreePresenter(model, new ConsoleView());
        this.scanner = new Scanner(System.in);
        this.work = true;
        this.commands = new ArrayList<>();
        initCommands();
    }

    private void initCommands() {
        commands.add(new AddHuman(this));
        commands.add(new GetHumanListInfo(this));
        commands.add(new SortByName(this));
        commands.add(new SortByBirthDate(this));
        commands.add(new Finish(this));
    }

    public void start() {
        System.out.println("Приветствую!");

        while (work) {
            System.out.println("Выберите команду:");
            for (int i = 0; i < commands.size(); i++) {
                System.out.println((i + 1) + ". " + commands.get(i).getDescription());
            }
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr) - 1;
            if (choice >= 0 && choice < commands.size()) {
                commands.get(choice).execute();
            } else {
                System.out.println("Неверный выбор");
            }
        }
    }

    public void finish() {
        work = false;
        System.out.println("До новых встреч!");
    }

    public void addHuman() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения (в формате dd.MM.yyyy)");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        presenter.addNode(name, birthDate);
    }

    public void getHumanListInfo() {
        presenter.getNodesListInfo();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }
}
