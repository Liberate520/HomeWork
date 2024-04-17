package family_tree;


import family_tree.model.family_tree.*;
import family_tree.model.human.Human;
import family_tree.view.ConsoleUI;


public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> tree = initializeFamilyTree();
        
        ConsoleUI consoleUI = new ConsoleUI(tree);
        consoleUI.start();
    }

    private static FamilyTree<Human> initializeFamilyTree() {
        return new FamilyTree<>();
    }
}