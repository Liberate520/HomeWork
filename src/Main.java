import model.FamilyTree.ItemFamilyTree;
import model.Humans.Human;
import model.Service.Service;
import Writers.FileHandler;
import model.FamilyTree.FamilyTree;
import view.ConsoleUI;
import view.View;

public class Main {
    public static <U extends ItemFamilyTree<U>> void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}