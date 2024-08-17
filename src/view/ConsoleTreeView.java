package view;

import presenter.Presenter;
import view.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleTreeView implements TreeView {
    private Presenter presenter;
    private Map<String, Command> commands;

    public ConsoleTreeView() {
        this.commands = new HashMap<>();
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
        initCommands();
    }

    private void initCommands() {
        commands.put("add", new AddPersonCommand(presenter));
        commands.put("find", new FindPersonCommand(presenter));
        commands.put("display", new DisplayAllPersonsCommand(presenter));
        commands.put("sortname", new SortByNameCommand(presenter));
        commands.put("sortbirth", new SortByBirthDateCommand(presenter));
        commands.put("save", new SaveTreeCommand(presenter));
        commands.put("load", new LoadTreeCommand(presenter));
        commands.put("addrelation", new AddRelationCommand(presenter));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (add, find, display, sortName, sortBirth, save, load, addRelation, exit): ");
            String command = scanner.nextLine().toLowerCase();
            if (command.equals("exit")) {
                break;
            }
            executeCommand(command);
        }
    }

    private void executeCommand(String command) {
        Command cmd = commands.get(command);
        if (cmd != null) {
            cmd.execute();
        } else {
            System.out.println("Unknown command.");
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayPerson(String personInfo) {
        System.out.println(personInfo);
    }

    @Override
    public void displayAllPersons(String personsInfo) {
        System.out.println(personsInfo);
    }
}
