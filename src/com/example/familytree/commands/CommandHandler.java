package com.example.familytree.commands;

import com.example.familytree.mvp.FamilyTreePresenter;
import com.example.familytree.mvp.FamilyTreePresenterImpl;
import com.example.familytree.mvp.FamilyTreeView;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandHandler {
    private final FamilyTreePresenterImpl presenter;
    private final FamilyTreeView view;
    private final Scanner scanner;
    private final Map<Integer, Command> commands = new HashMap<>();

    public CommandHandler(FamilyTreePresenter presenter, FamilyTreeView view) {
        this.presenter = (FamilyTreePresenterImpl) presenter;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void registerCommand(int choice, Command command) {
        commands.put(choice, command);
    }

    public void handleCommands() {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Command command = commands.get(choice);
            if (command != null) {
                command.execute();
            } else if (choice == 10) {
                running = false;
                System.out.println("Всего хорошего, до свидания!");
            } else {
                System.out.println("Неверная команда. Попробуйте еще раз.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nВыберите номер команды:");
        for (Map.Entry<Integer, Command> entry : commands.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getDescription());
        }
        System.out.println("10. Выход из программы");
    }
}
