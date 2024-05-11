package com.example.genealogy.model;
import java.util.Scanner;
import com.example.genealogy.filehandler.FileHandler;

public class Service {

    private GenealogyTreeModel genealogyTree;
    private FileHandler fileHandler;

    public Service() {
        this.genealogyTree = new GenealogyTreeModel();
        this.fileHandler = new FileHandler();
    }

    public void addPerson(String name) {
        genealogyTree.addPerson(name);
    }

    public void removePerson(String name) {
        genealogyTree.removePerson(name);
    }

    public void addRelationship(String person1, String person2, String relationship) {
        genealogyTree.addRelationship(person1, person2, relationship);
    }

    public void removeRelationship(String person1, String person2) {
        genealogyTree.removeRelationship(person1, person2);
    }

    public void printTree() {
        genealogyTree.printTree();
    }

    public void saveTree(String filename) {
        genealogyTree.saveTree(genealogyTree, filename);
    }

    public void loadTree(String filename) {
        genealogyTree = fileHandler.loadTree(filename);
    }

    public void runConsole() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду или help для получения справки:");
            String command = scanner.nextLine();

            switch (command) {
                case "add_person":
                    System.out.println("Введите имя человека:");
                    String name = scanner.nextLine();
                    addPerson(name);
                    break;
                case "remove_person":
                    System.out.println("Введите имя человека:");
                    name = scanner.nextLine();
                    removePerson(name);
                    break;
                case "add_relationship":
                    System.out.println("Введите имя первого человека:");
                    String person1 = scanner.nextLine();
                    System.out.println("Введите имя второго человека:");
                    String person2 = scanner.nextLine();
                    System.out.println("Введите тип отношений:");
                    String relationship = scanner.nextLine();
                    addRelationship(person1, person2, relationship);
                    break;
                case "remove_relationship":
                    System.out.println("Введите имя первого человека:");
                    person1 = scanner.nextLine();
                    System.out.println("Введите имя второго человека:");
                    person2 = scanner.nextLine();
                    removeRelationship(person1, person2);
                    break;
                case "print_tree":
                    printTree();
                    break;
                case "save_tree":
                    System.out.println("Введите имя файла для сохранения:");
                    String filename = scanner.nextLine();
                    saveTree(filename);
                    break;
                case "load_tree":
                    System.out.println("Введите имя файла для загрузки:");
                    filename = scanner.nextLine();
                    loadTree(filename);
                    break;
                case "help":
                    System.out.println("Доступные команды:");
                    System.out.println("add_person: добавить человека в семейное дерево");
                    System.out.println("remove_person: удалить человека из семейного дерева");
                    System.out.println("add_relationship: добавить отношения между людьми в семейном дереве");
                    System.out.println("remove_relationship: удалить отношения между людьми в семейном дереве");
                    System.out.println("print_tree: распечатать семейное дерево");
                    System.out.println("save_tree: сохранить семейное дерево в файл");
                    System.out.println("load_tree: загрузить семейное дерево из файла");
                    System.out.println("help: вывести справку по доступным командам");
                    System.out.println("exit: выйти из приложения");
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неизвестная команда. Введите help для получения справки.");
            }
        }
    }
}
