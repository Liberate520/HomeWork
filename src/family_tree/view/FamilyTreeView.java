package family_tree.view;

import family_tree.person.Person;

import java.util.Map;

public interface FamilyTreeView {
    void displayFamilyTree(Map<Integer, Person> familyTree);

    void displayErrorMessage(String message);

    void displaySuccessMessage(String message);

    int promptForPersonId();

    String promptForPersonName();

    String promptForPersonGender();

    int promptForPersonAge();

    int promptForSpouseId();

    int promptForMotherId();

    int promptForFatherId();

    int promptForChildId();

    void showMenu();
}
