import Writers.FHForFamilyTree;
import model.FamilyTree.ItemFamilyTree;
import model.Humans.Human;
import model.Service.Service;
import Writers.FileHandler;
import model.FamilyTree.FamilyTree;
import view.ConsoleUI;
import view.FamilyMenu;
import view.View;

public class Main {
    public static <U extends ItemFamilyTree<U>> void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        Service service = new Service(familyTree);
        service.setWriter(new FHForFamilyTree());
        service.saveTree();

        View view = new ConsoleUI();
        view.start();
    }
}