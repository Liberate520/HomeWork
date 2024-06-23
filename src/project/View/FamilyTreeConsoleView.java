package project.View;

import java.util.List;
import java.util.Scanner;
import project.Command.AddMemberCommand;
import project.Command.DisplayChildrenOfCommand;
import project.Command.LoadFamilyTreeCommand;
import project.Command.SaveFamilyTreeCommand;
import project.Command.SortByBirthDateCommand;
import project.Command.SortByNameCommand;
import project.Members.TreeMember;
import project.Presenter.FamilyTreePresenter;
import project.Presenter.FamilyTreePresenterImpl;

public class FamilyTreeConsoleView implements FamilyTreeView {
    private FamilyTreePresenter presenter;
    private Scanner scanner;
    private Menu menu;

    public FamilyTreeConsoleView() {
        this.presenter = new FamilyTreePresenterImpl(this);
        this.scanner = new Scanner(System.in);
        this.menu = new Menu();

        menu.addCommand(1, new AddMemberCommand(presenter, scanner));
        menu.addCommand(2, new SaveFamilyTreeCommand(presenter, scanner));
        menu.addCommand(3, new LoadFamilyTreeCommand(presenter, scanner));
        menu.addCommand(4, new DisplayChildrenOfCommand(presenter, scanner));
        menu.addCommand(5, new SortByNameCommand(presenter));
        menu.addCommand(6, new SortByBirthDateCommand(presenter));
        menu.addCommand(7, () -> System.exit(0));
    }

    @Override
    public void displayMemberDescriptions(List<String> descriptions) {
        for (String description : descriptions) {
            System.out.println(description);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayChildren(List<TreeMember> children) {
        if (children.isEmpty()) {
            System.out.println("Дети не найдены.");
        } else {
            for (TreeMember child : children) {
                System.out.println(child);
            }
        }
    }

    public void start() {
        while (true) {
            menu.display();
            int choice = Integer.parseInt(scanner.nextLine());
            menu.executeCommand(choice);
        }
    }
}