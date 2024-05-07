import Model.FamilyTree;
import Model.FileHandler;
import View.ConsoleUI;
import Service.FamilyTreeService;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Podgaynyy\\Desktop\\Programming\\GeekBrains\\Программист\\" +
                "Java\\OOP\\homeWork_Java_OOP\\save";
        File file = new File(filePath);
        FileHandler fileHandler = new FileHandler();
        FamilyTree familyTree;

        if (file.exists() && !file.isDirectory()) {
            familyTree = (FamilyTree) fileHandler.read(filePath);
            System.out.println("Family tree loaded from file.");
        } else {
            familyTree = new FamilyTree();
            System.out.println("New family tree created.");
        }

        FamilyTreeService service = new FamilyTreeService(familyTree, fileHandler);
        ConsoleUI view = new ConsoleUI(service);
        view.Start();
    }
}