
import com.familytree.model.family_tree.FamilyTreeModel;
import com.familytree.model.io.FileHandler;
import com.familytree.view.ConsoleUI;

public class Main {
        public static void main(String[] args) {
                FileHandler fileHandler = new FileHandler("src/tree.txt");
                FamilyTreeModel model = new FamilyTreeModel(fileHandler);
                ConsoleUI consoleUI = new ConsoleUI(model);
                consoleUI.start();
        }
}
