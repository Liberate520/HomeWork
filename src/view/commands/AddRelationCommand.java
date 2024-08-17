package view.commands;

import presenter.Presenter;
import view.Command;

import java.util.Scanner;

public class AddRelationCommand implements Command {
    private Presenter presenter;

    public AddRelationCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter parent's name: ");
        String parentName = scanner.nextLine();
        System.out.print("Enter child's name: ");
        String childName = scanner.nextLine();
        presenter.addRelation(parentName, childName);
    }
}
