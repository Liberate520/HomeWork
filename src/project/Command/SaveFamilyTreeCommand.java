package project.Command;

import java.util.Scanner;

import project.Presenter.FamilyTreePresenter;

public class SaveFamilyTreeCommand implements Command {
    private FamilyTreePresenter presenter;
    private Scanner scanner;

    public SaveFamilyTreeCommand(FamilyTreePresenter presenter, Scanner scanner) {
        this.presenter = presenter;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();
        presenter.saveFamilyTree(filename);
    }
}

