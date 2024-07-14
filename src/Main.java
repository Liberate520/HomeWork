import java.time.LocalDate;
import FamilyTree.FamilyTree;
import FamilyTree.ItemFamilyTree;
import Humans.Gender;
import Humans.Human;
import Service.Service;
import Writers.FileHandler;

public class Main {
    public static <U extends ItemFamilyTree<U>> void main(String[] args) {
        
        Service<U> service = new Service<U>();
        service.addHuman("Павлов Александр Иванович", LocalDate.of(1955, 12, 1), LocalDate.of(2022, 1, 20), Gender.Male);
        FamilyTree<Human> familyTree = testTree();
        saveTree(familyTree);
        System.out.println(familyTree);
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
