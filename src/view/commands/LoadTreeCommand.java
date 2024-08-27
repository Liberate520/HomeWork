package view.commands;

import presenter.Presenter;
import view.Command;

import java.util.Scanner;

public class LoadTreeCommand implements Command {
    private Presenter presenter;

    public LoadTreeCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file name to load the tree: ");
        String fileName = scanner.nextLine();

        presenter.loadTree(fileName);
    }

    @Override
    public String getName() {
        return "load";
    }
}
