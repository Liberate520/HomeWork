package Main;

import Controller.FamilyTreeController;
import Model.FamilyTree;
import Model.Person;
import Util.FileManager;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        FileManager fileManager = new FileManager();

        FamilyTreeController controller = new FamilyTreeController(familyTree, fileManager);
        controller.start();
    }
}
