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

        Service<U> service = new Service<U>();
        FamilyTree<Human> familyTree = testTree();
        saveTree(familyTree);
    }

    private static void saveTree(FamilyTree<Human> familyTree){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree);
    }

    private static FamilyTree<Human> testTree(){
        FamilyTree<Human> familyTree = new FamilyTree<Human>();

        System.out.println(familyTree);
        familyTree.sortByGender();
        return familyTree;
    }
}