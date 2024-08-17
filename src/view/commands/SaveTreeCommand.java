package view.commands;

import presenter.Presenter;
import view.Command;

import java.util.Scanner;

public class SaveTreeCommand implements Command {
    private Presenter presenter;

    public SaveTreeCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file name to save the tree: ");
        String fileName = scanner.nextLine();

        presenter.saveTree(fileName);
    }

    @Override
    public String getName() {
        return "save";
    }
}
