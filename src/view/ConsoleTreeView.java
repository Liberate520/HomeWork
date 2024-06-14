package view;

import model.Person;
import presenter.TreePresenter;

import java.util.List;
import java.util.Scanner;

public class ConsoleTreeView implements TreeView {
    private TreePresenter presenter;
    private Scanner scanner;

    public ConsoleTreeView() {
        this.scanner = new Scanner(System.in);
    }

    public void setPresenter(TreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        presenter.loadFamilyTree();
        while (true) {
            System.out.println("Enter command (add/find/children/exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    addMember();
                    break;
                case "find":
                    findMember();
                    break;
                case "children":
                    getChildrenOf();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    private void addMember() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter age:");
        int age = Integer.parseInt(scanner.nextLine());
        presenter.addMember(name, age);
    }

    private void findMember() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        presenter.findMember(name);
    }

    private void getChildrenOf() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        presenter.getChildrenOf(name);
    }

    @Override
    public void displayMembers(List<Person> members) {
        System.out.println("Family Tree Members:");
        for (Person person : members) {
            System.out.println(person);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayChildren(List<Person> children) {
        System.out.println("Children:");
        for (Person child : children) {
            System.out.println(child);
        }
    }
}
