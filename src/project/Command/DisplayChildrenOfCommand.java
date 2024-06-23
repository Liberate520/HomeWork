package project.Command;

import java.util.Scanner;

import project.Presenter.FamilyTreePresenter;

public class DisplayChildrenOfCommand implements Command {
    private FamilyTreePresenter presenter;
    private Scanner scanner;

    public DisplayChildrenOfCommand(FamilyTreePresenter presenter, Scanner scanner) {
        this.presenter = presenter;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Введите имя участника древа: ");
        String name = scanner.nextLine();
        presenter.displayChildrenOf(name);
    }
}

