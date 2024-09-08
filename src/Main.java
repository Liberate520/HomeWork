import model.FamilyTree.FamilyTree;
import model.FileHandler.FileHandler;
import model.Human.Human;
import view.ConsoleUI;

public class Main {
    final static String filePath = "src/writer/tree.txt";
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
    }
    private static FamilyTree load() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        return (FamilyTree) fileHandler.read();
    }

    private static void save(FamilyTree<Human> familyTree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        fileHandler.save(familyTree);
    }
}
