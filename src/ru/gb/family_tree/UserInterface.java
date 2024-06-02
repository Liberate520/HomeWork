package ru.gb.family_tree;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
    private FamilyTree<Node> familyTree;
    private Scanner scanner;

    public UserInterface() {
        this.familyTree = new FamilyTree<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Введите команду (add, remove, save, load, sortByName, sortByBirthDate, print, exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    addNode();
                    break;
                case "remove":
                    removeNode();
                    break;
                case "save":
                    saveTree();
                    break;
                case "load":
                    loadTree();
                    break;
                case "sortByName":
                    familyTree.sortByName();
                    break;
                case "sortByBirthDate":
                    familyTree.sortByBirthDate();
                    break;
                case "print":
                    familyTree.printTree();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда. Попробуйте еще раз.");
            }
        }
    }

    private void addNode() {
        // Реализация метода добавления узла
    }

    private void removeNode() {
        // Реализация метода удаления узла
    }

    private void saveTree() {
        // Реализация метода сохранения дерева
    }

    private void loadTree() {
        // Реализация метода загрузки дерева
    }
}