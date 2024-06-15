
import com.familytree.model.family_tree.FamilyTreeModel;
import com.familytree.model.family_tree.TreeNode;
import com.familytree.view.ConsoleUI;

public class Main {
        public static void main(String[] args) {
                FamilyTreeModel<TreeNode> treeModel = new FamilyTreeModel<>("src/tree.txt");
                ConsoleUI consoleUI = new ConsoleUI(treeModel);
                consoleUI.start();
        }
}
