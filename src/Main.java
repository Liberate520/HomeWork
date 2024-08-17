import familytree.FamilyTree;
import person.Person;
import presenter.Presenter;
import service.Service;
import view.ConsoleTreeView;
import writer.FileTreeStorage;
import writer.TreeStorage;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        TreeStorage<Person> storage = new FileTreeStorage<>();
        Service service = new Service(familyTree, storage);
        ConsoleTreeView view = new ConsoleTreeView();
        Presenter presenter = new Presenter(service, view);

        view.start();
    }
}
