import presenter.Presenter;
import service.Service;
import familytree.FamilyTree;
import person.Person;
import view.ConsoleTreeView;
import view.commands.*;
import writer.FileTreeStorage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        Service service = new Service(familyTree, new FileTreeStorage<>());
        ConsoleTreeView view = new ConsoleTreeView();
        Presenter presenter = new Presenter(service, view);

        view.addCommand(new AddPersonCommand(presenter));
        view.addCommand(new FindPersonCommand(presenter));
        view.addCommand(new DisplayAllPersonsCommand(presenter));
        view.addCommand(new SortByNameCommand(presenter));
        view.addCommand(new SortByBirthDateCommand(presenter));
        view.addCommand(new SaveTreeCommand(presenter));
        view.addCommand(new LoadTreeCommand(presenter));
        view.addCommand(new AddRelationCommand(presenter));

        view.start();
    }
}
