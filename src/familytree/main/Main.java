package familytree.main;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.ui.UserInterface;



public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        UserInterface ui = new UserInterface(familyTree);
        ui.start();
    }
}