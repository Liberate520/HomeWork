package view.commands;

import presenter.Presenter;
import view.Command;

import java.util.Scanner;

public class FindPersonCommand implements Command {
    private Presenter presenter;

    public FindPersonCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name to find: ");
        String name = scanner.nextLine();

        presenter.findPerson(name);
    }

    @Override
    public String getName() {
        return "find";
    }
}
