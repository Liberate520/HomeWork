import Model.FamilyTree;
import Model.FileHandler;
import Model.Gender;
import Model.Human;
import View.ConsoleUI;
import View.View;
import java.io.File;
import java.io.Serializable;

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

        View view = new ConsoleUI();
        view.Start();


    }
}