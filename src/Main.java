import familytree.FamilyTree;
import person.Person;
import presenter.Presenter;
import service.Service;
import service.TreeSorter;
import view.ConsoleTreeView;
import writer.FileTreeStorage;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        TreeSorter<Person> sorter = new TreeSorter<>();
        FileTreeStorage<Person> storage = new FileTreeStorage<>();
        Service service = new Service(familyTree, sorter, storage);
        ConsoleTreeView view = new ConsoleTreeView();
        Presenter presenter = new Presenter(service, view);

        view.start();
    }
}
